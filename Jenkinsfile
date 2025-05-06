pipeline {
    agent any

    triggers {
        githubPush()
    }

    stages {
        stage('Clonar repositorio') {
            steps {
                git url: 'https://github.com/Jhuly1215/HotelTransito.git',
                    branch: 'jhuls',
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
