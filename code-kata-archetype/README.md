# Criando um novo projeto para realizar um Kata

- Version 1.3 - Default
- Version 1.4 - Inclusao de estrutura para Node e impressao de arvore e mudanca na forma de criar teste unitario

```
mvn install
```
Dentro da pasta que deseja criar o projeto com base nste template rode:

```
mvn archetype:generate -DarchetypeGroupId=com.codekata -DarchetypeArtifactId=code-kata-archetype -DarchetypeVersion=1.4 -DgroupId=com.codekata -Dversion=1.0 -DartifactId=<NOME DO PROJETO>
```


