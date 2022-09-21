# Simple directory structure builder
Sometimes you need to quickly design your folder structure. If you're building a complex note structure from scratch, or if it's a massive photo album, you'll have to spend some time implementing nested folders (especially without linux mkdir braces). In order not to resort to third-party services (often requiring registration), a lightweight cross-platform folder builder based on a template was developed.

Simple editors like Notepad or WordPad on Windows use standard tabs instead of spaces. The program supports just such formatting.
Your structure should look something like this:
```text
vault name
	cat1
		cat11
		cat12
			cat121
	cat2
		cat21
			cat211
		cat22
		cat23
			cat231
				cat2311
	cat3
			cat311
```
cat311 has no parent directory and cannot be created.

In such an easy-to-read format, you can conveniently design structures of increased complexity, easily bringing them to life.

---
### Manual build process
Open the project directory in the terminal

- Compilation step
```text
javac -cp ./src -d ./out ./src/main/java/*.java 
```

- JAR-file packaging step
```text
jar cMf dir-structure-builder.jar -C out . -C ./src/main/resources META-INF
```

- Jar-file running step
```text
java -jar dir-structure-builder.jar template.txt .
```

The template.txt file must have the same structure as the file above. All information about errors that occurred during the creation of the folder structure will be displayed in the console.