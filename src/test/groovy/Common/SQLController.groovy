package Common

import groovy.sql.Sql


class SQLController {

    def runQueryReturnData(String sqlStatement){
        def ourString = Sql.newInstance("jdbc:sqlite:/Users/davesorenson/spock-example/src/test/resources/SampleDataBase/Sakila.sqlite3", "org.sqlite.JDBC")
        def rows = ourString.rows(sqlStatement)
        return rows
    }

}
