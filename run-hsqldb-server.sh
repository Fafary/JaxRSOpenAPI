mvn dependency:copy-dependencies
mkdir data 2> /dev/null
# shellcheck disable=SC2164
cd data
java -cp ../target/dependency/hsqldb-2.7.2.jar org.hsqldb.Server
