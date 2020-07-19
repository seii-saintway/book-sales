package:
	mkdir -p target/classes
	sh generate-jar.sh

run:
	java -cp target/book-sales-1.0-SNAPSHOT.jar:jar-files/gnujaxp.jar:jar-files/jcommon-1.0.16.jar:jar-files/jfreechart-1.0.13.jar cn.edu.whu.booksales.BookSalesFrame

package-standalone:
	mvn package

run-standalone:
	java -jar target/book-sales-1.0-SNAPSHOT-jar-with-dependencies.jar
