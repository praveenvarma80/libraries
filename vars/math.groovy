def gitDownload(repo)
{
    git "https://github.com/praveenvarma80/${repo}.git"
}
def buildArtifact()
{
     sh " mvn package "
}
def deployTomcat(jobname,ip,context)
{
   sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat10/webapps/${context}.war"
}
def RunSelenium(jobname)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
