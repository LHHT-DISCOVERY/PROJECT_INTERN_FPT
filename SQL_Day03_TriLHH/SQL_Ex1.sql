create database fpt_exam_1;
use fpt_exam_1;
create table nhan_vien(
	ma_nhan_vien int primary key,
    ho_ten varchar(255) ,
    gioi_tinh varchar(45) ,
    que_quan varchar(45) ,
    tuoi int
);

create table san_pham(
	ma_sp int  primary key ,
    ten varchar(255) ,
    ma_loai_sp int,
    gia_ban int ,
    foreign key(ma_loai_sp) references loai_sp(ma_loai_sp)
);

create table loai_sp(
	ma_loai_sp int primary key,
    ten_loai_sp varchar(255)
);

create table ban_hang(
	id int primary key ,
	ma_nhan_vien int  ,
    ma_sp int,
    so_luong_ban varchar(255),
    foreign key(ma_nhan_vien) references nhan_vien(ma_nhan_vien),
    foreign key(ma_sp) references san_pham(ma_sp)
);

alter table ban_hang modify so_luong_ban int;

INSERT INTO `fpt_exam_1`.`nhan_vien` (`ma_nhan_vien`, `ho_ten`, `gioi_tinh`, `que_quan`, `tuoi`) VALUES (1, 'Nguyễn Chí Phèo', 'Name', 'Quang Tri', '18');
INSERT INTO `fpt_exam_1`.`nhan_vien` (`ma_nhan_vien`, `ho_ten`, `gioi_tinh`, `que_quan`, `tuoi`) VALUES (2, 'Nguyễn Chí Phở', 'Name', 'Quang Tri', '18');
INSERT INTO `fpt_exam_1`.`nhan_vien` (`ma_nhan_vien`, `ho_ten`, `gioi_tinh`, `que_quan`, `tuoi`) VALUES (3, 'Nguyễn Chí Phi', 'Name', 'Quang Tri', '18');

INSERT INTO `fpt_exam_1`.`ban_hang` (`ma_nhan_vien`, `ma_sp`, `so_luong_ban`) VALUES (1, 1, 30);
INSERT INTO `fpt_exam_1`.`ban_hang` (`ma_nhan_vien`, `ma_sp`, `so_luong_ban`) VALUES (2, 2, 40);
INSERT INTO `fpt_exam_1`.`ban_hang` (`ma_nhan_vien`, `ma_sp`, `so_luong_ban`) VALUES (2, 1, 32);
INSERT INTO `fpt_exam_1`.`ban_hang` (`ma_nhan_vien`, `ma_sp`, `so_luong_ban`) VALUES (4, 2, 0);



UPDATE `fpt_exam_1`.`ban_hang` SET `ma_nhan_vien` = '2', `ma_sp` = '1' WHERE (`ma_nhan_vien` = '4');




delete from nhan_vien  where gioi_tinh = "nu" and que_quan = "hue";

UPDATE `fpt_exam_1`.`san_pham` SET `gia_ban` = gia_ban*200 WHERE ma_loai_sp = "Type001";

SELECT * FROM nhan_vien where tuoi>=23 and que_quan="Bình Định";

SELECT ma_sp from ban_hang where so_luong_ban > 0;

SELECT * from nhan_vien where ho_ten like "Huu%" ;

select *  from nhan_vien where reverse(ho_ten) LIKE "irt%";

SELECT * from san_pham where char_length(trim(ten)) = 8;

SELECT * from san_pham where gia_ban < 20 or ma_sp not in (select ma_sp from ban_hang );

select nv.ho_ten , nv.ma_nhan_vien  from nhan_vien nv join ban_hang bh on bh.ma_nhan_vien = nv.ma_nhan_vien where  not in (nv.ma_nhan_vien)
