.PHONY: download-checkstyle lint-java lint-ts new-readme-entry encode-path prettify-readme

CHECKSTYLE_JAR_URL=https://github.com/checkstyle/checkstyle/releases/download/checkstyle-9.3/checkstyle-9.3-all.jar
CHECKSTYLE_JAR_LOCATION=~/checkstyle-9.3-all.jar

JAVA_SOURCE_DIRECTORY=./solutions/Java
TYPESCRIPT_SOURCE_DIRECTORY=./solutions/TypeScript
MYSQL_SOURCE_DIRECTORY=./solutions/MySQL
BASH_SOURCE_DIRECTORY=./solutions/Bash
PANDAS_SOURCE_DIRECTORY=./solutions/Pandas

# Download checkstyle Jar for linting Java files
download-checkstyle:
	curl -L ${CHECKSTYLE_JAR_URL} --output ${CHECKSTYLE_JAR_LOCATION}

# Lint Java
lint-java:
	$(if $(strip $(ID)), $(eval PATH_TO_LINT=$(shell find ${JAVA_SOURCE_DIRECTORY} -name *${ID}*)), $(eval PATH_TO_LINT=${JAVA_SOURCE_DIRECTORY}))
	$(eval PATH_TO_LINT=$(subst `,\`,$(PATH_TO_LINT)))
	java -jar ${CHECKSTYLE_JAR_LOCATION} -c ${JAVA_SOURCE_DIRECTORY}/checkstyle.xml "${PATH_TO_LINT}"

# Lint TypeScript
lint-ts:
	yarn --cwd ${TYPESCRIPT_SOURCE_DIRECTORY} eslint ./

# Generate entry for use in README
new-readme-entry:
	$(if $(strip $(ID)), $(eval FILE_PATH=$(shell find ${JAVA_SOURCE_DIRECTORY} ${TYPESCRIPT_SOURCE_DIRECTORY} ${MYSQL_SOURCE_DIRECTORY} ${BASH_SOURCE_DIRECTORY} ${PANDAS_SOURCE_DIRECTORY} -name *${ID}* | tr '\n' ',')))
	$(eval FILE_PATH=$(subst `,\`,$(FILE_PATH)))
	@python3 -c 'import urllib.parse, subprocess; \
	raw_input=input(); \
	raw_input=raw_input.split(","); \
	java_folder=next((item for item in raw_input if "${JAVA_SOURCE_DIRECTORY}" in item), None); \
	typescript_folder=next((item for item in raw_input if "${TYPESCRIPT_SOURCE_DIRECTORY}" in item), None); \
	mysql_folder=next((item for item in raw_input if "${MYSQL_SOURCE_DIRECTORY}" in item), None); \
	bash_folder=next((item for item in raw_input if "${BASH_SOURCE_DIRECTORY}" in item), None); \
	pandas_folder=next((item for item in raw_input if "${PANDAS_SOURCE_DIRECTORY}" in item), None); \
	import re; \
	[problem_id, problem_name] = re.search(r"\[(\d+)_.*\]\s(.*)", raw_input[0]).groups(); \
	level=raw_input[0].split("]")[0].split("_")[1]; \
	encoded_java_path=f"[✓]({urllib.parse.quote(java_folder)})" if java_folder else ""; \
	encoded_typescript_path=f"[✓]({urllib.parse.quote(typescript_folder)})" if typescript_folder else ""; \
	encoded_mysql_path=f"[✓]({urllib.parse.quote(mysql_folder)})" if mysql_folder else ""; \
	encoded_bash_path=f"[✓]({urllib.parse.quote(bash_folder)})" if bash_folder else ""; \
	encoded_pandas_path=f"[✓]({urllib.parse.quote(pandas_folder)})" if pandas_folder else ""; \
	readme_entry=f"| {int(problem_id)}. {problem_name} | {level} | {encoded_java_path} | {encoded_typescript_path} | {encoded_mysql_path} | {encoded_bash_path} | {encoded_pandas_path} |"; \
	print(f"Entry generated:\n{readme_entry if readme_entry else None}"); \
	subprocess.run("pbcopy", text=True, input=readme_entry) if readme_entry else print("Path with given ID not found")' <<< "${FILE_PATH}"

# Generate entry for use in README when using GitHub codespace
# Generate entry for use in README
new-readme-entry-on-codespace:
	$(if $(strip $(ID)), $(eval FILE_PATH=$(shell find ${JAVA_SOURCE_DIRECTORY} ${TYPESCRIPT_SOURCE_DIRECTORY} ${MYSQL_SOURCE_DIRECTORY} ${BASH_SOURCE_DIRECTORY} ${PANDAS_SOURCE_DIRECTORY} -name *${ID}* | tr '\n' ',')))
	$(eval FILE_PATH=$(subst `,\`,$(FILE_PATH)))
	@python3 -c 'import urllib.parse, subprocess; \
	raw_input="${FILE_PATH}"; \
	raw_input=raw_input.split(","); \
	java_folder=next((item for item in raw_input if "${JAVA_SOURCE_DIRECTORY}" in item), None); \
	typescript_folder=next((item for item in raw_input if "${TYPESCRIPT_SOURCE_DIRECTORY}" in item), None); \
	mysql_folder=next((item for item in raw_input if "${MYSQL_SOURCE_DIRECTORY}" in item), None); \
	bash_folder=next((item for item in raw_input if "${BASH_SOURCE_DIRECTORY}" in item), None); \
	pandas_folder=next((item for item in raw_input if "${PANDAS_SOURCE_DIRECTORY}" in item), None); \
	import re; \
	[problem_id, problem_name] = re.search(r"\[(\d+)_.*\]\s(.*)", raw_input[0]).groups(); \
	level=raw_input[0].split("]")[0].split("_")[1]; \
	encoded_java_path=f"[✓]({urllib.parse.quote(java_folder)})" if java_folder else ""; \
	encoded_typescript_path=f"[✓]({urllib.parse.quote(typescript_folder)})" if typescript_folder else ""; \
	encoded_mysql_path=f"[✓]({urllib.parse.quote(mysql_folder)})" if mysql_folder else ""; \
	encoded_bash_path=f"[✓]({urllib.parse.quote(bash_folder)})" if bash_folder else ""; \
	encoded_pandas_path=f"[✓]({urllib.parse.quote(pandas_folder)})" if pandas_folder else ""; \
	readme_entry=f"| {int(problem_id)}. {problem_name} | {level} | {encoded_java_path} | {encoded_typescript_path} | {encoded_mysql_path} | {encoded_bash_path} | {encoded_pandas_path} |"; \
	print(f"Entry generated:\n{readme_entry if readme_entry else None}")'

# Encode folder path for use in README
encode-path:
	$(if $(strip $(ID)), $(eval FILE_PATH=$(shell find ${JAVA_SOURCE_DIRECTORY} -name *${ID}*)))
	@python3 -c 'import urllib.parse, subprocess; \
	encoded_path=urllib.parse.quote(input()); \
	print(f"Path encoded:\n{encoded_path if encoded_path else None}"); \
	subprocess.run("pbcopy", text=True, input=encoded_path) if encoded_path else print("Path with given ID not found")' <<< "${FILE_PATH}"

# Prettify README.md
prettify-readme:
	npx prettier **/*.md --write
