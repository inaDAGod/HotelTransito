pipeline {
    agent any

    environment {
        DEPLOY_DIR = 'C:/xampp/tomcat/webapps/HotelTransito'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/inaDAGod/HotelTransito'
            }
        }

        stage('Verificar archivos') {
            steps {
                echo 'Verificando archivos HTML...'
                bat '''
                if not exist src\\index.html (
                    echo "index.html no encontrado en src"
                    exit /b 1
                )
                '''
            }
        }

        stage('Deploy') {
            steps {
                echo "Desplegando en Tomcat..."
                bat '''
                if exist "%DEPLOY_DIR%" rmdir /S /Q "%DEPLOY_DIR%"
                mkdir "%DEPLOY_DIR%"
                xcopy /E /I /Y src "%DEPLOY_DIR%"
                '''
            }
        }
    }

    post {
        success {
            echo "✅ ¡Despliegue exitoso!"
        }
        failure {
            echo "❌ Hubo un error durante el pipeline."
        }
    }
}
