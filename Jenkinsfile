pipeline {
    agent any

    triggers {
        githubPush()  // Este es el trigger para builds automáticos en push
    }

    environment {
        JAVA_HOME = "/usr/lib/jvm/java-17-openjdk"
        PATH = "${JAVA_HOME}/bin:${PATH}"
    }

    stages {
        stage('Clonar repositorio') {
            steps {
                git branch: "jhuls"
                git 'https://github.com/Jhuly1215/HotelTransito.git'
                credentialsId: '7a4ed59d-b080-4c62-bf88-82a94e118c6a'
            }
        }

        stage('Compilar proyecto') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Empaquetar') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            echo '✅ Build exitoso tras push a GitHub.'
        }
        failure {
            echo '❌ El build falló tras el push.'
        }
    }
}
