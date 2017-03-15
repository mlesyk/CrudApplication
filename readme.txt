Устанавливать в Tomcat ROOT:
1. Открыть {TOMCAT_HOME_DIR}/conf/server.xml
2. Найти там тэг (или добавить):
      <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true" >
      </Host>
3. Внутрь добавить:
     <Context path="" docBase="CrudApplication">

       <!-- Default set of monitored resources -->
       <WatchedResource>WEB-INF/web.xml</WatchedResource>

     </Context>
4. Получится такая иерархия:
      <Host name="localhost"  appBase="webapps" unpackWARs="true" autoDeploy="true" >
        <Context path="" docBase="CrudApplication">
            <WatchedResource>WEB-INF/web.xml</WatchedResource>
        </Context>
        <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
               prefix="localhost_access_log." suffix=".txt"
               pattern="%h %l %u %t &quot;%r&quot; %s %b" />
      </Host>

e-mail: maksym@lesyk.org
skype: maks.lesyk

Database: test
Table: user
Login: root
Password: root

SQL данные лежат в папке database_scripts