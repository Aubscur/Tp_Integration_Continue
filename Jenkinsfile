node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'apache-maven-3.8.4';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Tp_Integration_Continue -Dsonar.host.url=http://localhost:9000 -Dsonar.login=974f343d882f91e69ad48e28bf5f575946403dac"
    }
  }
}
