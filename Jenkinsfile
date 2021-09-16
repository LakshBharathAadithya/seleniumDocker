pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                script {
                	app = docker.build("bharathgr/testimage1")
                }
            }
        }
        stage('Push Image') {
             steps {
                 script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
            			        	app.push("${BUILD_NUMBER}")
            			            app.push("latest")
                    }
                 }
             }
        }
    }
}
