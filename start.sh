while true; do
ls $1*.kt | sort -R | while read filename; do
	echo $filename
	java -jar backend-bugfinder/target/backendBugFinder-1.0-jar-with-dependencies.jar $filename
done
done