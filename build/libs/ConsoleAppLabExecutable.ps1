$collection= Read-Host -prompt "Enter name of the file containing collection"
$env:COLLECTION = $collection
java -jar ConsoleAppLab-1.0-SNAPSHOT-all.jar