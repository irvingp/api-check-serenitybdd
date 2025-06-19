# Usa la imagen oficial de Jenkins con JDK 17 LTS
FROM jenkins/jenkins:lts-jdk17

# Cambia a usuario root para instalar paquetes
USER root

# Variables para la versión de Maven y su instalación
ENV MAVEN_VERSION=3.8.8
ENV MAVEN_HOME=/opt/maven
ENV PATH=${MAVEN_HOME}/bin:${PATH}

# Actualiza e instala curl y unzip para descargar y descomprimir Maven
RUN apt-get update && apt-get install -y curl unzip && \
    # Descarga Maven oficial
    curl -fsSL https://downloads.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz -o /tmp/maven.tar.gz && \
    # Descomprime en /opt
    tar -xzf /tmp/maven.tar.gz -C /opt && \
    # Renombra la carpeta para tener una ruta fija
    mv /opt/apache-maven-${MAVEN_VERSION} ${MAVEN_HOME} && \
    # Limpia archivos temporales y caches
    rm /tmp/maven.tar.gz && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Cambia de nuevo a usuario Jenkins (seguridad)
USER jenkins
