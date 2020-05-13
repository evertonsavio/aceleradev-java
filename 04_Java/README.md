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
