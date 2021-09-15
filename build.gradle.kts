plugins {
    id("scala")
    id("io.gatling.gradle") version "3.6.1"
}

val googleGsonVersion = "2.8.0"
val apacheCommonsVersion = "3.4"
val cglibVersion = "3.2.0"

dependencies {
    gatling("com.google.code.gson:gson:$googleGsonVersion")
    gatlingImplementation("org.apache.commons:commons-lang3:$apacheCommonsVersion")
    gatlingRuntimeOnly("cglib:cglib-nodep:$cglibVersion")
}

gatling {
    withGroovyBuilder {
        "simulations" {
            "include"("**/*.scala")
        }
    }
}

// gatling {
//     simulations = {
//     include "**/*.scala"
// }
//     logLevel = 'WARN'
//     jvmArgs = ['-server', '-Xms512m', '-Xmx512m', '-server', '-Xmx768m',
//         '-XX:+UseG1GC', '-XX:MaxGCPauseMillis=30',
//         '-XX:G1HeapRegionSize=16m',
//         '-XX:InitiatingHeapOccupancyPercent=75',
//         '-XX:+ParallelRefProcEnabled',
//         '-XX:+PerfDisableSharedMem',
//         '-XX:+AggressiveOpts',
//         '-XX:+OptimizeStringConcat',
//         '-XX:+HeapDumpOnOutOfMemoryError',
//         '-Djava.net.preferIPv4Stack=true',
//         '-Djava.net.preferIPv6Addresses=false'
//     ]
// }
