SOURCE_DIRECTORY=src/main/java/cn/edu/whu/booksales
JAR_DIRECTORY=jar-files
CLASSPATH="target/classes:${JAR_DIRECTORY}/gnujaxp.jar:${JAR_DIRECTORY}/jcommon-1.0.16.jar:${JAR_DIRECTORY}/jfreechart-1.0.13.jar"
javac -d target/classes -cp $CLASSPATH $SOURCE_DIRECTORY/Book.java
javac -d target/classes -cp $CLASSPATH $SOURCE_DIRECTORY/BookList.java
javac -d target/classes -cp $CLASSPATH $SOURCE_DIRECTORY/BookFrame.java
javac -d target/classes -cp $CLASSPATH $SOURCE_DIRECTORY/ChartFrame.java
javac -d target/classes -cp $CLASSPATH $SOURCE_DIRECTORY/Sale.java
javac -d target/classes -cp $CLASSPATH $SOURCE_DIRECTORY/SortByTotal.java
javac -d target/classes -cp $CLASSPATH $SOURCE_DIRECTORY/SaleList.java
javac -d target/classes -cp $CLASSPATH $SOURCE_DIRECTORY/BookSalesFrame.java
jar cvfm target/book-sales-1.0-SNAPSHOT.jar manifest -C target/classes .
