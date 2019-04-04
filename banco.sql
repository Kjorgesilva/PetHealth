use  pethealth;

drop table if exists tab_vacina;
drop table if exists tab_tipo_vacina;
drop table if exists tab_histoico;
drop table if exists tab_resposta_relatorio;
drop table if exists tab_pergunta_relatorio;
drop table if exists tab_relatorio_medico;
drop table if exists tab_agendamento;
drop table if exists tab_endereco;
drop table if exists tab_medico;
drop table if exists tab_animal;
drop table if exists tab_cliente;
drop table if exists tab_usuario;
drop table if exists tab_perfil;




 
create table tab_perfil(
		id_perfil int NOT NULL AUTO_INCREMENT,
		descricao varchar (255) not null,
		primary key (id_perfil)
	);
    

 
create table tab_usuario(
		id_usuario int NOT NULL AUTO_INCREMENT,
        login varchar (255) not null,
        senha varchar (255) not null,
        nome varchar (255) not null,
        email varchar (255) not null,
        id_perfil INTEGER not null,
        primary key(id_usuario),
        CONSTRAINT id_perfil_fk FOREIGN KEY (id_perfil) REFERENCES tab_perfil (id_perfil)
	);
  
    
   
create table tab_cliente(
		id_cliente int NOT NULL AUTO_INCREMENT,
        nome varchar (255) not null,
        rg varchar (255) not null,
        endereco varchar (255) not null,
        telefone varchar (255) not null,
        email varchar (255) not null,
        id_usuario INTEGER,
        primary key (id_cliente),
        CONSTRAINT id_usuario_cliente_fk FOREIGN KEY (id_usuario) REFERENCES tab_usuario (id_usuario)
	);
       
    
    create table tab_animal (
		id_animal int NOT NULL AUTO_INCREMENT,
        nome  varchar (255) not null,
        raca varchar (255) not null,
        cor varchar (255),
        data_de_nascimento timestamp,
        sexo varchar (1) not null,
        pais_de_origem varchar (255),
        observacoes varchar(255),
        id_cliente int ,
		PRIMARY KEY (id_animal),
		CONSTRAINT sexo_ck check (sexo in('M','F')) ,
        CONSTRAINT cliente_fk foreign key (id_cliente) references tab_cliente (id_cliente)
  
  ); 
    
    
create table tab_medico (
		id_medico int NOT NULL AUTO_INCREMENT,
        nome varchar (255)not null,
        telefone varchar (255)not null,
        email varchar (255) not null,
        id_usuario INTEGER not null,
        primary key (id_medico),
        CONSTRAINT id_usuario_medico_fk FOREIGN KEY (id_usuario) REFERENCES tab_usuario (id_usuario)
	);   
    
    
create table tab_endereco(
		id_endereco int NOT NULL AUTO_INCREMENT,
        rua varchar (255) not null,
        cidade varchar (255) not null,
        bairro varchar (255) not null,
        estado varchar (255)not null,
        primary key (id_endereco)
	);   

create table tab_agendamento(
		id_agendamento int NOT NULL AUTO_INCREMENT,
        data_de_inicio timestamp not null,
		data_de_fim timestamp,
        primary key (id_agendamento),
        id_cliente INTEGER not null,
		id_medico INTEGER not null,
		id_endereco INTEGER not null,
		CONSTRAINT id_cliente_agendamento_fk FOREIGN KEY (id_cliente) REFERENCES tab_cliente (id_cliente),
        CONSTRAINT id_medico_agendamento_fk FOREIGN KEY (id_medico) REFERENCES tab_medico (id_medico),
        CONSTRAINT id_endereco_agendamento_fk FOREIGN KEY (id_endereco) REFERENCES tab_endereco (id_endereco)
	);
    
    
    
create table tab_pergunta_relatorio(
		id_pergunta_relatorio int NOT NULL AUTO_INCREMENT,
        descricao varchar (255) not null,
        primary key (id_pergunta_relatorio)
	);
       


create table tab_resposta_relatorio(
		id_resposta_relatorio int NOT NULL AUTO_INCREMENT,
        resposta varchar (255) not null,
        id_pergunta_relatorio INTEGER not null,
		id_cliente INTEGER not null,
		id_medico INTEGER not null,
		id_animal INTEGER not null,
        primary key (id_resposta_relatorio),
        CONSTRAINT id_cliente_relatorio_medico_fk FOREIGN KEY (id_cliente) REFERENCES tab_cliente (id_cliente),
        CONSTRAINT id_medico_relatorio_medico_fk FOREIGN KEY (id_medico) REFERENCES tab_medico (id_medico),
        CONSTRAINT id_animal_relatorio_medico_fk FOREIGN KEY (id_animal) REFERENCES tab_animal (id_animal),
        CONSTRAINT id_pergunta_relatorio_fk FOREIGN KEY (id_pergunta_relatorio) REFERENCES tab_pergunta_relatorio (id_pergunta_relatorio)
	);
    

create table tab_histoico(
		id_historico int NOT NULL AUTO_INCREMENT,
        id_agendamento INTEGER not null,
        primary key (id_historico),
		CONSTRAINT id_agendamento_fk FOREIGN KEY (id_agendamento) REFERENCES tab_agendamento (id_agendamento)
	);
    
 
create table tab_tipo_vacina(
		id_tipo_vacina int primary key NOT NULL AUTO_INCREMENT,
        descricao varchar (255)not null
        
	);
   
create table tab_vacina(
		id_vacina int primary key NOT NULL AUTO_INCREMENT,
        aviso varchar (255),
        data_vacina timestamp ,
		data_da_proxima timestamp ,	
		descricao varchar (255) ,
        id_animal INTEGER ,
		id_tipo_vacina INTEGER ,
        vacina_em_dia boolean,        
        CONSTRAINT id_animal_vacina_fk FOREIGN KEY (id_animal) REFERENCES tab_animal (id_animal),
        CONSTRAINT id_tipo_vacina_fk FOREIGN KEY (id_tipo_vacina) REFERENCES tab_tipo_vacina (id_tipo_vacina)
	);
    
    

    
INSERT INTO tab_perfil (id_perfil,descricao)
VALUES(1,'cliente');

INSERT INTO tab_perfil (id_perfil,descricao)
VALUES(2,'medico');




INSERT INTO tab_usuario
(login,senha,nome,email,id_perfil)
VALUES('cliente','cliente','Pedro Silva', 'pedroSilva@outlook.com' ,1);

INSERT INTO tab_usuario
(login,senha,nome,email,id_perfil)
VALUES('medico','medico','luizinho Silva', 'luizinhoSilva@outlook.com' ,2);

INSERT INTO tab_cliente
(nome,rg,endereco,telefone,email,id_usuario)
VALUES('Pedro','33333333-3', 'Rua Dois' ,'5555-5555','pedroSilva@outlook.com' ,1);

INSERT INTO tab_animal
(nome,raca,cor,data_de_nascimento,sexo,pais_de_origem,observacoes,id_cliente)
VALUES('gato','gato alemao','Branco', now() ,'M','Brasil',NULL,1);

INSERT INTO tab_medico
(nome,telefone,email,id_usuario)
VALUES('Pedro','5555-5555','pedroSilva@outlook.com' ,1);

INSERT INTO tab_endereco
(rua,cidade,bairro,estado)
VALUES('Rua dois','São Paulo','Barra funda' ,'São Paulo');

INSERT INTO tab_agendamento
(data_de_inicio,data_de_fim,id_cliente,id_medico,id_endereco)
VALUES(now(),now(),1,1,1);


INSERT INTO tab_pergunta_relatorio
(descricao)
VALUES('Hidratação');  
INSERT INTO tab_pergunta_relatorio
(descricao)
VALUES('Pelagem');
INSERT INTO tab_pergunta_relatorio
(descricao)
VALUES('Frequencia Cardiaca');  
INSERT INTO tab_pergunta_relatorio
(descricao)
VALUES('Sistema Respiratorio');  
INSERT INTO tab_pergunta_relatorio
(descricao)
VALUES('Cavidade Oral');  
INSERT INTO tab_pergunta_relatorio
(descricao)
VALUES('Condutores Auditivos');  
INSERT INTO tab_pergunta_relatorio
(descricao)
VALUES('Temperatura');  




INSERT INTO tab_resposta_relatorio
(resposta,id_pergunta_relatorio,id_cliente,id_medico,id_animal)
VALUES('resposta do relatorio',1,1,1,1);  

INSERT INTO tab_histoico
(id_agendamento)
VALUES(1); 

/*Tipos de vacinas para Pets*/
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('1', 'V3');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('2', 'V4');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('3', 'V5');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('4', 'V8');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('5', 'Rinotraqueite Infecciosa');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('6', 'V10');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('7', 'Gripe Canina');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('8', 'Giardiase');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('9', 'Anti- Rábica');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('10', 'Calicivirose');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('11', 'Panleucopenia');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('12', 'Clamidiose');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('13', 'Leucemia Felina');
INSERT INTO `pethealth`.`tab_tipo_vacina` (`id_tipo_vacina`, `descricao`) VALUES ('14', 'Vermifungo');



INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,1,false);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,2,true);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,3,false);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,4,true);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,5,false);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,6,false);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,7,true);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,8,true);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,9,false);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,10,true);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,11,false);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,12,true);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,13,false);

INSERT INTO tab_vacina
(aviso,data_vacina,data_da_proxima,descricao,id_animal,id_tipo_vacina,vacina_em_dia)
VALUES('resposta Vacina alerta para a proxima',now(),now(),'descricao',1 ,14,true);



