databaseChangeLog = {

    changeSet(author: "rain (generated)", id: "1705829083439-1") {
        createTable(tableName: "person") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "personPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "first_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "class", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "address", type: "VARCHAR(255)")

            column(name: "telephone", type: "VARCHAR(255)")

            column(name: "city", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "rain (generated)", id: "1705829083439-2") {
        createTable(tableName: "pet") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "petPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "type_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "owner_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "birth_date", type: "timestamp") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "rain (generated)", id: "1705829083439-3") {
        createTable(tableName: "pet_type") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "pet_typePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(20)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "rain (generated)", id: "1705829083439-4") {
        createTable(tableName: "speciality") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "specialityPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(20)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "rain (generated)", id: "1705829083439-5") {
        createTable(tableName: "vet_speciality") {
            column(name: "vet_specialities_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "speciality_id", type: "BIGINT")
        }
    }

    changeSet(author: "rain (generated)", id: "1705829083439-6") {
        createTable(tableName: "visit") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "visitPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "pet_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "date", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "rain (generated)", id: "1705829083439-7") {
        addUniqueConstraint(columnNames: "name", constraintName: "UC_PET_TYPENAME_COL", tableName: "pet_type")
    }

    changeSet(author: "rain (generated)", id: "1705829083439-8") {
        addUniqueConstraint(columnNames: "name", constraintName: "UC_SPECIALITYNAME_COL", tableName: "speciality")
    }

    changeSet(author: "rain (generated)", id: "1705829083439-9") {
        addForeignKeyConstraint(baseColumnNames: "owner_id", baseTableName: "pet", constraintName: "FK8lhtmxst31168frxixwf1c7eb", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person", validate: "true")
    }

    changeSet(author: "rain (generated)", id: "1705829083439-10") {
        addForeignKeyConstraint(baseColumnNames: "vet_specialities_id", baseTableName: "vet_speciality", constraintName: "FKfek3m6p8mh8dcjlr6ksye38dv", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person", validate: "true")
    }

    changeSet(author: "rain (generated)", id: "1705829083439-11") {
        addForeignKeyConstraint(baseColumnNames: "speciality_id", baseTableName: "vet_speciality", constraintName: "FKns25xuxcyf46sbycxgsblcvja", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "speciality", validate: "true")
    }

    changeSet(author: "rain (generated)", id: "1705829083439-12") {
        addForeignKeyConstraint(baseColumnNames: "pet_id", baseTableName: "visit", constraintName: "FKpr2103nfb1ueid78p80lvv1ed", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pet", validate: "true")
    }

    changeSet(author: "rain (generated)", id: "1705829083439-13") {
        addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "pet", constraintName: "FKrem5eg7ygof60lwmbo8gif3qg", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pet_type", validate: "true")
    }
}
