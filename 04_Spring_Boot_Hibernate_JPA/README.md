## Postgres  
```
CREATE TABLE usuario (id BIGINT PRIMARY KEY, login VARCHAR(45) NOT NULL, cpf VARCHAR(14) UNIQUE NOT NULL, nome VARCHAR(120) NOT NULL);
```
```
CREATE TABLE disciplina (id BIGINT PRIMARY KEY, nome VARCHAR(80) UNIQUE NOT NULL);
```
```
ALTER TABLE disciplina ADD COLUMN descricao VARCHAR(60);
```
```
CREATE TABLE professor (id BIGINT PRIMARY KEY, idUsuario BIGINT NOT NULL, FOREIGN KEY(idUsuario) REFERENCES usuario(id) );
```
### One to One
```
CREATE TABLE aluno(id BIGINT PRIMARY KEY, idUsuario BIGINT REFERENCES usuario(id));
```
### Many to many
```
CREATE TABLE disciplina_alunos(idAluno BIGINT REFERENCES aluno(id), idDisciplina BIGINT REFERENCES disciplina(id), PRIMARY KEY(idAluno, idDisciplina));
```
### One to Many
```
ALTER TABLE disciplina ADD COLUMN idProfessor BIGINT REFERENCES professor(id);
```

--------------------------------------------------------------------------------------------
### POSTGRES -> OBS USAR ASPAS SIMPLES NAS QUEUES  
```
CREATE SEQUENCE professor_id_seq;  
ALTER TABLE professor ALTER id set default nextval('professor_id_seq');  
DELETE * FROM PROFESSOR;  
ALTER TABLE professor DROP column idUsuario;  
UPDATE professor SET cpf = 123, nome = "professor1" WHERE id = 1;  
INSERT INTO professor (cpf) VALUES ('19100000000');  
SELECT id, idUsuario from professor where nome like '%joao%' and descricao = 'mestrando';  
INSERT INTO professor (cpf, nome) VALUES(123, 'joao');  
SELECT a.nome, d.nome from aluno as a INNER JOIN disciplina_aluno da ON a.id = da.idaluno INNER JOIN disciplina d on d.id = da.iddisciplina;  
SELECT count(id) from professor;
SELECT id, nome, count(iddisciplina) FROM disciplina_aluno da INNER JOIN disciplina d on da.iddisciplina = d.id GROUP BY nome, id ORDER BY id desc;  --> desc de descendente; 
```