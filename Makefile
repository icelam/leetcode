.PHONY: download-checkstyle lint-java lint-ts encode-path prettify-readme

CHECKSTYLE_JAR_URL=https://github.com/checkstyle/checkstyle/releases/download/checkstyle-9.3/checkstyle-9.3-all.jar
CHECKSTYLE_JAR_LOCATION=~/checkstyle-9.3-all.jar

JAVA_SOURCE_DIRECTORY=./solutions/Java
TYPESCRIPT_SOURCE_DIRECTORY=./solutions/TypeScript

# Download checkstyle Jar for linting Java files
download-checkstyle:
	curl -L ${CHECKSTYLE_JAR_URL} --output ${CHECKSTYLE_JAR_LOCATION}

# Lint Java
lint-java:
	$(if $(strip $(ID)), $(eval PATH_TO_LINT=$(shell find ${JAVA_SOURCE_DIRECTORY} -name *${ID}*)), $(eval PATH_TO_LINT=${JAVA_SOURCE_DIRECTORY}))
	java -jar ${CHECKSTYLE_JAR_LOCATION} -c ${JAVA_SOURCE_DIRECTORY}/checkstyle.xml "${PATH_TO_LINT}"

# Lint TypeScript
lint-ts:
	yarn --cwd ${TYPESCRIPT_SOURCE_DIRECTORY} eslint ./

# Encode folder path for use in README
encode-path:
	$(if $(strip $(ID)), $(eval FILE_PATH=$(shell find ${JAVA_SOURCE_DIRECTORY} -name *${ID}*)))
	@python3 -c 'import urllib.parse, subprocess; \
	encoded_path=urllib.parse.quote(input()); \
	print(f"Path encoded:\n{encoded_path if encoded_path else None}"); \
	subprocess.run("pbcopy", text=True, input=encoded_path) if encoded_path else print("Path with given ID not found")' <<< "${FILE_PATH}"

# Prettify README.md
prettify-readme:
	npx prettier README.md --write
