/********************************************************
********* Criar tabelas do banco SADA 1.0 ***************
*********************************************************/
CREATE DATABASE BDAnaliseAcad;

USE BDAnaliseAcad;

CREATE TABLE login(
	id_login int(8) not null primary key auto_increment,
	user varchar(18) not null,
	pwd varchar(18) not null
);

insert into login (user,pwd) values ("admin","123");

CREATE TABLE tbaluno(
	idalu int(8) not null primary key auto_increment, 
        nome varchar(150) not null, 
        nasc date default '1990-01-01',
        rua varchar(100),
        numero char(5),
        bairro varchar(100),
	cep char(10),
	cidade varchar(50),
	estado char(2)
);

CREATE TABLE tbtelefone(
	idfone int(8) not null primary key auto_increment,
	idalu int(8) not null,
	ddd char(2) default '85',
	numero varchar(15) not null,
	tipo char(5) not null,
	operadora varchar(20),
	foreign key (idalu) references tbaluno(idalu)
);

CREATE TABLE tbcurso(
	idcur int(8) not null primary key auto_increment,
	especificacao varchar(150) not null,
	carga_horaria int(4) not null,
	observacao varchar(250)
);

CREATE TABLE tbdisciplina(
	iddisc int(8) not null primary key,
	especificacao varchar(150) not null,
	natureza varchar(100),
	objetivo varchar(150),
	carga_horaria int(4) not null,
	observacao varchar(250)
);

CREATE TABLE tbcurdisc(
	idcur int(8) not null,
	iddisc int(8) not null,
	foreign key (idcur) references tbcurso(idcur),
	foreign key (iddisc) references tbdisciplina(iddisc),
	primary key(idcur, iddisc)
);

CREATE TABLE tbmovimento(
	idmov int(8) not null primary key auto_increment,
	idcur int(8) not null,
	iddisc int(8) not null,
	idalu int(8) not null,
	nota1 float,
	nota2 float,
	nota3 float,
	nota4 float,
	nota5 float,
	nota6 float,
	falta int(3),
	turma varchar(100),
	dataAlteracao date,
	foreign key (idalu) references tbaluno(idalu),
	foreign key (idcur) references tbcurso(idcur),
	foreign key (iddisc) references tbdisciplina(iddisc)
);

/***************************************************
************** Procedures de inserção **************
****************************************************/

/*
	Inserindo disciplina
*/

DELIMITER $$
DROP PROCEDURE if exists inserir_disc$$
CREATE PROCEDURE inserir_disc (
	IDC INT(8),
	IDD INT(8),
	ESP VARCHAR(150),
	NAT VARCHAR(100),
	OBJ VARCHAR(150),
	CARGA INT(4),
	OBS VARCHAR(250))
	main : BEGIN
		insert into tbdisciplina (iddisc,especificacao,natureza,objetivo,carga_horaria,observacao) 
		values (idd,esp,nat,obj,carga,obs);
		insert into tbcurdisc values (idc,idd);
	end$$
DELIMITER ;

/*
	Inserir aluno1
*/

DELIMITER $$
DROP PROCEDURE IF EXISTS inserir_aluno1 $$
CREATE PROCEDURE inserir_aluno1(
	id int(8),
	nome_alu varchar(150),
	nasc_alu date,
	rua_alu varchar(150),
	num char(5),
	bairro_alu varchar(100),
	cep_alu char(10),
	cidade_alu varchar(50),
	uf char(2),
	idfone1 int(8),
	ddd1 char(2),
	numero1 varchar(15),
	tipo1 char(5),
	oper1 varchar(20)
)
	main : begin
		insert into tbaluno (idalu,nome,nasc,rua,numero,bairro,cep,cidade,estado)
		values (id,nome_alu,nasc_alu,rua_alu,num,bairro_alu,cep_alu,cidade_alu,uf);
		insert into tbtelefone (idfone,idalu,ddd,numero,tipo,operadora) values (idfone1,id,ddd1,numero1,tipo1,oper1);
	end$$
DELIMITER ;

/*
	Inserir aluno2
*/

DELIMITER $$
DROP PROCEDURE if exists inserir_aluno2 $$
CREATE PROCEDURE inserir_aluno2(
	id int(8),
	nome_alu varchar(150),
	nasc_alu date,
	rua_alu varchar(150),
	num char(5),
	bairro_alu varchar(100),
	cep_alu char(10),
	cidade_alu varchar(50),
	uf char(2),
	idfone1 int(8),
	ddd1 char(2),
	numero1 varchar(15),
	tipo1 char(5),
	oper1 varchar(20),
	idfone2 int(8),
	ddd2 char(2),
	numero2 varchar(15),
	tipo2 char(5),
	oper2 varchar(20)
)
	main : BEGIN
		INSERT INTO tbaluno (idalu,nome,nasc,rua,numero,bairro,cep,cidade,estado)
		VALUES (id,nome_alu,nasc_alu,rua_alu,num,bairro_alu,cep_alu,cidade_alu,uf);
		INSERT INTO tbtelefone (idfone,idalu,ddd,numero,tipo,operadora) VALUES (idfone1,id,ddd1,numero1,tipo1,oper1);
		INSERT INTO tbtelefone (idfone,idalu,ddd,numero,tipo,operadora) VALUES (idfone2,id,ddd2,numero2,tipo2,oper2);
	END$$
DELIMITER ;

/***************************************************
************** Procedures de alterações ************
****************************************************/

/*
	Alterar disciplina
*/

DELIMITER $$
DROP PROCEDURE if exists alterar_disc $$
CREATE PROCEDURE alterar_disc(
	idd int(8),
	idc int(8),
	esp varchar(150),
	nat varchar(100),
	obj varchar(150),
	carga int(4),
	obs varchar(150))
	main : BEGIN
		UPDATE tbdisciplina SET especificacao=esp,natureza=nat,objetivo=obj,carga_horaria=carga,observacao=obs WHERE iddisc=idd;
		UPDATE tbcurdisc SET idcur=idc WHERE iddisc=idd;
	END$$
DELIMITER ;

UPDATE tbdisciplina SET especificacao="ALGORITMO II" WHERE iddisc=53808;
UPDATE tbcurdisc SET idcur=2 WHERE iddisc=53808;

select * from tbdisciplina;
select * from tbcurdisc;
select * from tbcurso;

/*
	Alterar aluno 1
*/

DELIMITER $$
DROP PROCEDURE if exists alterar_aluno$$
CREATE PROCEDURE alterar_aluno(
	ida  int(8),
	nome_alu varchar(150),
	nasc_alu date,
	rua_alu varchar(100),
	num char(5),
	bairro_alu varchar(100),
	cep_alu char(10),
	cidade_alu varchar(50),
	est_alu char(2),
	idfone1 int(8),
	ddd1 char(2),
	fone1 varchar(15),
	tipo1 char(5),
	oper1 varchar(20))
	main:BEGIN
			UPDATE tbaluno SET
								nome=nome_alu,
								nasc=nasc_alu,
								rua=rua_alu,
								numero=num,
								bairro=bairro_alu,
								cep=cep_alu,
								cidade=cidade_alu,
								estado=est_alu
			WHERE idalu=ida;
			UPDATE tbtelefone SET
								ddd=ddd1,
								numero=fone1,
								tipo=tipo1,
								operadora=oper1
			WHERE idfone=idfone1;
	END$$
DELIMITER ;

/*
	Alterar aluno 2
*/

DELIMITER $$
DROP PROCEDURE if exists alterar_aluno2$$
CREATE PROCEDURE alterar_aluno2(
	ida  int(8),
	nome_alu varchar(150),
	nasc_alu date,
	rua_alu varchar(100),
	num char(5),
	bairro_alu varchar(100),
	cep_alu char(10),
	cidade_alu varchar(50),
	est_alu char(2),
	idfone1 int(8),
	ddd1 char(2),
	fone1 varchar(15),
	tipo1 char(5),
	oper1 varchar(20),
	idfone2 int(8),
	ddd2 char(2),
	fone2 varchar(15),
	tipo2 char(5),
	oper2 varchar(20))
	main:BEGIN
			UPDATE tbaluno SET
								nome=nome_alu,
								nasc=nasc_alu,
								rua=rua_alu,
								numero=num,
								bairro=bairro_alu,
								cep=cep_alu,
								cidade=cidade_alu,
								estado=est_alu
			WHERE idalu=ida;
			UPDATE tbtelefone SET
								ddd=ddd1,
								numero=fone1,
								tipo=tipo1,
								operadora=oper1
			WHERE idfone=idfone1;
			UPDATE tbtelefone SET
								ddd=ddd2,
								numero=fone2,
								tipo=tipo2,
								operadora=oper2
			WHERE idfone=idfone2;
	END$$
DELIMITER ;

/**********************************************
********** Procedures de exclusões ************
***********************************************/

/*
	Deletar disciplina
*/

DELIMITER $$
DROP PROCEDURE if exists excluir_disc$$
CREATE PROCEDURE excluir_disc(
	idd int(8))
	main : BEGIN
		DELETE FROM tbcurdisc WHERE iddisc=idd;
		DELETE FROM tbmovimento WHERE iddisc=idd;
		DELETE FROM tbdisciplina WHERE iddisc=idd;
	END$$
DELIMITER ;

call excluir_disc (1);

/*
	Deletar aluno
*/

DELIMITER $$
DROP PROCEDURE if exists excluir_aluno$$
CREATE PROCEDURE excluir_aluno(
	ida  int(8))
	main:BEGIN
			DELETE FROM tbmovimento WHERE idalu=ida;
			DELETE FROM tbtelefone WHERE idalu=ida;
			DELETE FROM tbaluno WHERE idalu=ida;
	END$$
DELIMITER ;

/*
	Deletar curso
*/

DELIMITER $$
DROP PROCEDURE if exists excluir_curso$$
CREATE PROCEDURE excluir_curso(
	idc  int(8))
	main:BEGIN
			DELETE FROM tbcurdisc WHERE idcur=idc;
			DELETE FROM tbmovimento WHERE idcur=idc;
			DELETE FROM tbcurso WHERE idcur=idc;
	END$$
DELIMITER ;	
