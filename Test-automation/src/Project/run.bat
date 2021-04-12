set profilepath=/root/eclipse-workspace/Test-automation
set classpath=%profilepath%/lib/*;%profilepath%/bin; 
cd %profilepath%
java org.testng.TestNG %profilepath%/testng.xml
