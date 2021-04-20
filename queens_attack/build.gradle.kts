//gradle command-line run:
//gradle run --args="hernan atlanta"

//jar command-line run:
//java -jar hello-1.0.0.jar hernan atlanta

plugins {
    application
}

application {
    mainClassName = "hernanbosqued.samples.MainKt"
}

dependencies {
    testImplementation("junit:junit:4.12")
}

val run: JavaExec by tasks
run.standardInput = System.`in`


tasks.jar {
    manifest {
        attributes["Main-Class"] = application.mainClassName
    }

    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
}