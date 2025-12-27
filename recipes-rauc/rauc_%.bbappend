FILESEXTRAPATHS:prepend := "${THISDIR}/rauc:"
SRC_URI += "file://system.conf"

# D-Bus, systemd und unnötige Funktionen über EXTRA_OEMESON deaktivieren.
# Der `:append` Operator stellt sicher, dass diese Optionen zu den Standard-Optionen 
# des Original-Rezepts hinzugefügt werden und die entsprechenden Standard-Werte überschreiben.

# D-Bus / systemd-Service komplett ausknipsen
PACKAGECONFIG:remove = "service"

# Falls das Subpaket trotzdem definiert ist, dbus-Abhängigkeit entfernen
RDEPENDS:${PN}-service:remove = "dbus"

# Optional: falls du wirklich GAR KEINE Service-Dateien willst:
FILES:${PN}-service = ""



EXTRA_OEMESON:append = " \
    -Dservice=false \
    -Ddbusinterfacesdir= \
    -Ddbuspolicydir= \
    -Ddbussystemservicedir= \
    -Dsystemdunitdir= \
    -Dsystemdcatalogdir= \
    -Dtests=false \
    -Dnetwork=false \
    -Dstreaming=false \
"

DEPENDS:remove = "dbus"
RDEPENDS:${PN}:remove = "dbus"
RDEPENDS:${PN}-dev:remove = "dbus"
RDEPENDS:${PN}:remove = "systemd"

# **Wichtig:** Bereinigung des Installationspfades.
# Auch wenn D-Bus deaktiviert ist, stellen wir sicher, dass keine Reste installiert werden,
# die zu Build- oder Paket-Fehlern führen könnten (z.B. bei der Lizenzprüfung).
do_install:append() {
    rm -rf ${D}${datadir}/dbus-1 || true
    install -d ${D}${sysconfdir}/rauc
    install -m 0644 ${UNPACKDIR}/system.conf ${D}${sysconfdir}/rauc/system.conf

}
