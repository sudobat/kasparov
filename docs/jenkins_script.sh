####################################
###### ENVIRONMENT VARIABLES #######
####################################
LEADER_IP=3.71.204.237
PORT=8080
export PROJECT_NAME=Kasparov
export DATE=$(date '+%Y-%m-%d-%H-%M-%S')
#export FOLDER_NAME=/tmp/${PROJECT_NAME}_${DATE}

# Build
chmod +x mvnw
./mvnw clean package

# Send jar
connectionString=ubuntu@${LEADER_IP}
local_jar_path=./target/
remote_app_path=/home/ubuntu/apps/kasparov/
java_version_path=$remote_app_path"jar-versions/"

artifactId=$(./mvnw help:evaluate -Dexpression=project.artifactId -q -DforceStdout)
version=$(./mvnw help:evaluate -Dexpression=project.version -q -DforceStdout)

jar_file=$artifactId-$version.jar
remote_jar_file=$remote_app_path$artifactId.jar
service_name=$artifactId.service

ssh-keyscan ${LEADER_IP} >> ~/.ssh/known_hosts &&

#Copiamos versión en remoto
scp ./target/$jar_file $connectionString:$java_version_path$jar_file

#Borramos el enlace simbólico
ssh $connectionString "sudo rm $remote_jar_file"

#Creamos el nuevo enlace simbólico
ssh $connectionString "sudo ln -s $java_version_path$jar_file $remote_jar_file"

#Despliegue
ssh $connectionString "sudo systemctl restart $service_name"

#Notificación
ssh $connectionString "curl -X POST -H 'Content-type: application/json' --data '{\"text\":\"Se ha desplegado la versión $version de la app!\"}' https://hooks.slack.com/services/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"