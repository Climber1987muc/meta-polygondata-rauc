SUMMARY = "RAUC Updater written in Rust"
DESCRIPTION = "Rust-basierte Anwendung für RAUC-Updates"
HOMEPAGE = "https://github.com/Climber1987muc/rauc-marker-service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f6a8a81aaacfead07ed85bbe4eeed378"

inherit cargo
inherit openrc

RDEPENDS:${PN} += "openrc"


CARGO_DISABLE_NETWORK = "0"
CARGO_FROZEN = "0"
do_configure[network] = "1"
do_compile[network] = "1"


# Git via SSH
SRC_URI = "git://github.com/Climber1987muc/rauc-marker.git;branch=main;protocol=ssh;user=git"

# Entweder feste Revision:
# SRCREV = "abcdef1234567890..."
# oder für Entwicklung:
SRCREV = "8cb2e8389919a2130d05654ef417defe0fbfef38"

S = "${WORKDIR}/git"

# Cargo-Source-Verzeichnis (normalerweise das Repo-Root)
#CARGO_SRC_DIR = "${S}"

# Optional: falls dein Binary anders heißt als der Paketname:
# CARGO_BUILD_FLAGS += "--bin rauc-updater"

# Install-Schritt: Binary nach ${bindir} kopieren
do_install() {
    install -d ${D}${sbindir}
    install -m 0755  ${B}/target/aarch64-oe-linux-musl/release/rauc-health ${D}${sbindir}/rauc-health
    openrc_install_initd ${S}/service/rauc-health.initd
}


OPENRC_SERVICES:${PN}      = " rauc-health "
OPENRC_AUTO_ENABLE:${PN}   = "enable"


# Pakete
RDEPENDS:${PN} = ""
