package com.example.managerment_player_footbal.service.impl;

import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.model.request.PlayerRequest;
import com.example.managerment_player_footbal.repository.account_repository.AccountRepository;
import com.example.managerment_player_footbal.repository.classes_repository.IPlayerRepository;
import com.example.managerment_player_footbal.service.IFileService;
import com.example.managerment_player_footbal.service.IPlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {

     AccountRepository accountRepository ;
    private final IPlayerRepository playerRepository;

    private final IFileService fileService;

    private final ModelMapper modelMapper;

    public PlayerService(IPlayerRepository playerRepository, IFileService fileService, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.fileService = fileService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Player> getAll() {
        List<Player> playerEntities = playerRepository.findAll();
        return playerEntities;
    }

    @Override
    public Player getByID(int id) {
        return playerRepository.findByPlayerId(id).orElse(new Player());
    }

    @Override
    public List<Player> getByClassId(int id) {
        return playerRepository.findAllByClassId(id);
    }

    @Override
    public Player findByPlayerUserName( String userName) {
        return playerRepository.findByPlayerUserName(userName).orElse(null);
    }


    @Override
    public Player save(PlayerRequest playerRequest) {
        Optional<Player> findByPlayerEntity = playerRepository.findByPlayerId(playerRequest.getPlayerId());
        Player player = modelMapper.map(playerRequest, Player.class);
        String avatarPath;
        String oldUrl;
        if (playerRequest.getPlayerId() == 0) {
            oldUrl = "/player/dist/img/avatar/";
        } else {
            oldUrl = findByPlayerEntity.get().getAvatar();
        }
        String realUrl = new File(".").getAbsolutePath();
        if (playerRequest.getAvatar() != null) {
            // Xóa file cũ
            File file = new File(realUrl + "\\src\\main\\resources\\static\\player\\dist\\img\\avatar\\"
                    + oldUrl.substring(oldUrl.lastIndexOf("/") + 1));

            File target = new File(realUrl + "\\target\\classes\\static\\player\\dist\\img\\avatar\\" +
                    oldUrl.substring(oldUrl.lastIndexOf("/") + 1));

            file.delete();
            target.delete();

            // Thêm file mới được chọn
            String pathFile = realUrl + "\\src\\main\\resources\\static\\player\\dist\\img\\avatar";
            File fileSaved = fileService.uploadFile(playerRequest.getAvatar(), pathFile);
            avatarPath = "/player/dist/img/avatar/" + fileSaved.getName();
            File targetAvatar = new File(realUrl + "\\target\\classes\\static\\player\\dist\\img\\avatar\\" + fileSaved.getName());
            fileService.copyFile(fileSaved, targetAvatar);
        } else {
            avatarPath = oldUrl;
        }
        player.setAvatar(avatarPath);
        player = playerRepository.save(player);
        return player;
    }


    @Override
    public List<Player> findAllByIdClass(int id) {
        return playerRepository.findAllByClassId(id);
    }

    @Override
    public Player getById(int id) {
        return playerRepository.findByPlayerId(id).orElse(null);
    }


}
