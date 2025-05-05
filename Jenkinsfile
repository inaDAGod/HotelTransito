pipeline {
    agent any

    environment {
        JAVA_HOME = "/usr/lib/jvm/java-17-openjdk"
        PATH = "${JAVA_HOME}/bin:${PATH}"
    }

    stages {
        stage('Clonar repositorio') {
            steps {
                git 'https://github.com/Jhuly1215/HotelTransito.git'
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
}
