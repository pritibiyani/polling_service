Links: 
1. Plugin used: [https://github.com/bmuschko/gradle-docker-plugin](https://github.com/bmuschko/gradle-docker-plugin)
2. [Documentation](http://bmuschko.github.io/gradle-docker-plugin/#spring_boot_application_plugin)
3. [Custom tasks available](http://bmuschko.github.io/gradle-docker-plugin/#remote_api_plugin) 


Issues faced:

[x] Not able to bind port while creating container task.
 
[x] Not able to find PID for the container task written.

Issues solved with the help of following: 
1. [Link] (https://github.com/bmuschko/gradle-docker-plugin/issues/171)

```
import com.bmuschko.gradle.docker.tasks.container.*
import com.bmuschko.gradle.docker.tasks.image.*

task copyJar(type: Copy) {
    dependsOn   'jar'
    from        'build/libs/rest-app-0.0.1-SNAPSHOT.jar'
    into        'build/docker'

    from        'src/main/resources/Dockerfile'
    into        'build/docker'
}

task buildImage(type: DockerBuildImage) {
    dependsOn 'copyJar'
    inputDir = file('build/docker');
    url = 'unix:///var/run/docker.sock'
    tag = 'rest-app/nci:0.1'
}

task createContainer(type: DockerCreateContainer) {
    dependsOn buildImage
    containerName = 'my-rest-app'
    targetImageId { buildImage.getImageId() }
    portBindings = ['8080:8080']
}

task startContainer(type: DockerStartContainer) {
    dependsOn createContainer
    targetContainerId { createContainer.getContainerId()}
}

build.dependsOn copyJar
build.dependsOn buildImage
build.dependsOn createContainer

```


