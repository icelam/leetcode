.PHONY: download-checkstyle lint-java lint-ts prettify-readme

CHECKSTYLE_JAR_URL=https://github.com/checkstyle/checkstyle/releases/download/checkstyle-9.3/checkstyle-9.3-all.jar
CHECKSTYLE_JAR_LOCATION=~/checkstyle-9.3-all.jar

JAVA_SOURCE_DIRECTORY=./solutions/Java
TYPESCRIPT_SOURCE_DIRECTORY=./solutions/TypeScript

# Download checkstyle Jar for linting Java files
download-checkstyle:
	curl -L ${CHECKSTYLE_JAR_URL} --output ${CHECKSTYLE_JAR_LOCATION}

# Lint Java
lint-java:
	java -jar ${CHECKSTYLE_JAR_LOCATION} -c ${JAVA_SOURCE_DIRECTORY}/checkstyle.xml ${JAVA_SOURCE_DIRECTORY}

# Lint TypeScript
lint-ts:
	yarn --cwd ${TYPESCRIPT_SOURCE_DIRECTORY} eslint ./

# Prettify README.md
prettify-readme:
	npx prettier README.md --write
