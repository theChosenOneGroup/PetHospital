INSERT INTO `pethospital`.`tb_questions` (`question_id`, `type`, `text`, `answer`) VALUES ('1', '猪', '猪瘟病的潜伏期为（）天', '4-21');
INSERT INTO `pethospital`.`tb_questions` (`question_id`, `type`, `text`, `answer`) VALUES ('2', '牛', '牛的发情周期一般为（）天', '21');
INSERT INTO `pethospital`.`tb_questions` (`question_id`, `type`, `text`, `answer`) VALUES ('3', '畜牧', '采用放牧方式养羊时，草地的适宜利用率是（）%', '50-65');
INSERT INTO `pethospital`.`tb_questions` (`question_id`, `type`, `text`, `answer`) VALUES ('4', '牛', '最易感染牛副结核病的是（）', '幼龄牛');
INSERT INTO `pethospital`.`tb_questions` (`question_id`, `type`, `text`, `answer`) VALUES ('5', '羊', '影响山羊绒生长的主要因素是（）', '光照周期');
INSERT INTO `pethospital`.`tb_questions` (`question_id`, `type`, `text`, `answer`) VALUES ('6', '羊', '羊的妊娠期平均为（）天', '150');
INSERT INTO `pethospital`.`tb_questions` (`question_id`, `type`, `text`, `answer`) VALUES ('7', '羊', '舍饲肉羊时，每只成年羊每天应饲喂的食盐量为（）克', '7-15');
INSERT INTO `pethospital`.`tb_questions` (`question_id`, `type`, `text`, `answer`) VALUES ('8', '鸡', '鸡新城疫病的主要传染来源是（）', '病鸡');
INSERT INTO `pethospital`.`tb_questions` (`question_id`, `type`, `text`, `answer`) VALUES ('9', '兔', '如果室内空气不好，家兔最容易得（）', '巴氏杆菌病');
INSERT INTO `pethospital`.`tb_questions` (`question_id`, `type`, `text`, `answer`) VALUES ('10', '内科', '在送检的病料中，有一块肝脏，你不能用它做以下哪种检验（）', '红细胞计数');



INSERT INTO `pethospital`.`tb_medicine` (`medicine_id`, `name`, `cost`) VALUES ('1', '氨苯磺胺', '10');
INSERT INTO `pethospital`.`tb_medicine` (`medicine_id`, `name`, `cost`) VALUES ('2', '复方新诺明', '15');
INSERT INTO `pethospital`.`tb_medicine` (`medicine_id`, `name`, `cost`) VALUES ('3', '青霉素G钠', '8');
INSERT INTO `pethospital`.`tb_medicine` (`medicine_id`, `name`, `cost`) VALUES ('4', '氨节青霉素', '16');
INSERT INTO `pethospital`.`tb_medicine` (`medicine_id`, `name`, `cost`) VALUES ('5', '硫酸链霉素', '22');
INSERT INTO `pethospital`.`tb_medicine` (`medicine_id`, `name`, `cost`) VALUES ('6', '土霉素', '71');
INSERT INTO `pethospital`.`tb_medicine` (`medicine_id`, `name`, `cost`) VALUES ('7', '四环素', '32');
INSERT INTO `pethospital`.`tb_medicine` (`medicine_id`, `name`, `cost`) VALUES ('8', '林可霉素', '50');
INSERT INTO `pethospital`.`tb_medicine` (`medicine_id`, `name`, `cost`) VALUES ('9', '阿托品', '2');
INSERT INTO `pethospital`.`tb_medicine` (`medicine_id`, `name`, `cost`) VALUES ('10', '胃复安', '6');




INSERT INTO `pethospital`.`tb_labwork` (`labwork_id`, `labwork_name`, `cost`) VALUES ('1', '体格检查', '100');
INSERT INTO `pethospital`.`tb_labwork` (`labwork_id`, `labwork_name`, `cost`) VALUES ('2', '血常规检查', '100');
INSERT INTO `pethospital`.`tb_labwork` (`labwork_id`, `labwork_name`, `cost`) VALUES ('3', '血液生化检查', '200');
INSERT INTO `pethospital`.`tb_labwork` (`labwork_id`, `labwork_name`, `cost`) VALUES ('4', '胸部X-线检查', '500');
INSERT INTO `pethospital`.`tb_labwork` (`labwork_id`, `labwork_name`, `cost`) VALUES ('5', '腹部超声检查', '400');
INSERT INTO `pethospital`.`tb_labwork` (`labwork_id`, `labwork_name`, `cost`) VALUES ('6', '粪便检查', '30');
INSERT INTO `pethospital`.`tb_labwork` (`labwork_id`, `labwork_name`, `cost`) VALUES ('7', '尿液检查', '30');
INSERT INTO `pethospital`.`tb_labwork` (`labwork_id`, `labwork_name`, `cost`) VALUES ('8', 'X光检查', '600');
INSERT INTO `pethospital`.`tb_labwork` (`labwork_id`, `labwork_name`, `cost`) VALUES ('9', '血液寄生虫检查', '200');
INSERT INTO `pethospital`.`tb_labwork` (`labwork_id`, `labwork_name`, `cost`) VALUES ('10', '耳分泌物检查', '30');



INSERT INTO `pethospital`.`tb_vaccine` (`vaccine_id`, `vaccine_name`, `cost`) VALUES ('1', '狂犬病疫苗','200');
INSERT INTO `pethospital`.`tb_vaccine` (`vaccine_id`, `vaccine_name`, `cost`) VALUES ('2', '猫三联苗', '110');
INSERT INTO `pethospital`.`tb_vaccine` (`vaccine_id`, `vaccine_name`, `cost`) VALUES ('3', '猫瘟热疫苗', '70');
INSERT INTO `pethospital`.`tb_vaccine` (`vaccine_id`, `vaccine_name`, `cost`) VALUES ('4', '兔瘟苗', '90');
INSERT INTO `pethospital`.`tb_vaccine` (`vaccine_id`, `vaccine_name`, `cost`) VALUES ('5', '维克疫苗', '120');
INSERT INTO `pethospital`.`tb_vaccine` (`vaccine_id`, `vaccine_name`, `cost`) VALUES ('6', '高升疫苗', '150');
INSERT INTO `pethospital`.`tb_vaccine` (`vaccine_id`, `vaccine_name`, `cost`) VALUES ('7', '英特威疫苗', '30');
INSERT INTO `pethospital`.`tb_vaccine` (`vaccine_id`, `vaccine_name`, `cost`) VALUES ('8', '苏威疫苗', '200');
INSERT INTO `pethospital`.`tb_vaccine` (`vaccine_id`, `vaccine_name`, `cost`) VALUES ('9', '小犬二联', '50');
INSERT INTO `pethospital`.`tb_vaccine` (`vaccine_id`, `vaccine_name`, `cost`) VALUES ('10', '细小病单联', '100');



INSERT INTO `pethospital`.`tb_user` (`user_id`, `user_name`, `password`, `authority`) VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `pethospital`.`tb_user` (`user_id`, `user_name`, `password`, `authority`, `label_type`) VALUES ('2', 'abc654321', '123456', '0', '初级班');
INSERT INTO `pethospital`.`tb_user` (`user_id`, `user_name`, `password`, `authority`, `label_type`) VALUES ('3', 'qwe123456', '123456789', '0', '初级班');
INSERT INTO `pethospital`.`tb_user` (`user_id`, `user_name`, `password`, `authority`, `label_type`) VALUES ('4', 'qwe654321', '123456', '0', '初级班');
INSERT INTO `pethospital`.`tb_user` (`user_id`, `user_name`, `password`, `authority`, `label_type`) VALUES ('5', 'asd123456', '123456', '0', '初级班');
INSERT INTO `pethospital`.`tb_user` (`user_id`, `user_name`, `password`, `authority`, `label_type`) VALUES ('6', 'asd654321', '1234567', '0', '初级班');
INSERT INTO `pethospital`.`tb_user` (`user_id`, `user_name`, `password`, `authority`, `label_type`) VALUES ('7', 'zxc123456', '123456', '0', '中级班');
INSERT INTO `pethospital`.`tb_user` (`user_id`, `user_name`, `password`, `authority`, `label_type`) VALUES ('8', 'zxc654321', '123456', '0', '高级班');
INSERT INTO `pethospital`.`tb_user` (`user_id`, `user_name`, `password`, `authority`, `label_type`) VALUES ('9', 'iop123456', '12345678', '0', '高级班');
INSERT INTO `pethospital`.`tb_user` (`user_id`, `user_name`, `password`, `authority`, `label_type`) VALUES ('10', 'iop654321', '123456', '0', '中级班');


INSERT INTO `pethospital`.`tb_office` (`office_id`, `persion_name`, `office_name`) VALUES ('1', '医生1', '挂号处');
INSERT INTO `pethospital`.`tb_office` (`office_id`, `persion_name`, `office_name`) VALUES ('2', '医生2', '内科诊室');
INSERT INTO `pethospital`.`tb_office` (`office_id`, `persion_name`, `office_name`) VALUES ('3', '医生3', '外科诊室');
INSERT INTO `pethospital`.`tb_office` (`office_id`, `persion_name`, `office_name`) VALUES ('4', '医生4', '中兽医诊室');
INSERT INTO `pethospital`.`tb_office` (`office_id`, `persion_name`, `office_name`) VALUES ('5', '医生5', '化验室');
INSERT INTO `pethospital`.`tb_office` (`office_id`, `persion_name`, `office_name`) VALUES ('6', '医生6', '病理诊断室');
INSERT INTO `pethospital`.`tb_office` (`office_id`, `persion_name`, `office_name`) VALUES ('7', '医生7', '微生物诊断室');
INSERT INTO `pethospital`.`tb_office` (`office_id`, `persion_name`, `office_name`) VALUES ('8', '医生8', 'B超室');
INSERT INTO `pethospital`.`tb_office` (`office_id`, `persion_name`, `office_name`) VALUES ('9', '医生9', 'X-光室');
INSERT INTO `pethospital`.`tb_office` (`office_id`, `persion_name`, `office_name`) VALUES ('10', '医生10', '药房');

