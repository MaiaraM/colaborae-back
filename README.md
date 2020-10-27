# ColaboraÊ API Rest

### Configurações (Intellij Community)
 * Lombok

> Settings > Annotation Processors 

Marque o campo "Enable annotation processing"

> Settings > Plugins  

Procure por Lombok e instale

* Dev-tools

> Settings >  Build Tools

Marque o Campo "Reload project ..."

> Settings >  Build, Execution, Depĺoyment > Compiler 

Marque o campo "Build project automatically"

> Ctrl + Shift + Alt + / > Registry

Marque o campo "compiler.automake.allow.when.app.running"

### Roda Projeto (Intellij)

![Configuração](https://github.com/MaiaraM/colaborae-back/blob/feature/1-models/images/config.png?raw=true)


### Roda Projeto (Docker)

No terminal digite 
> mvn clean install -DskipTests=true

> docker-compose up --build

