from jboss/wildfly:8.2.0.Final
RUN /opt/jboss/wildfly/bin/add-user.sh -up mgmt-users.properties admin Admin#70365 --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

USER root

RUN chmod -R 777 /opt/jboss

USER 1000