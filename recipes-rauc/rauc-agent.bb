SUMMARY = "RAUC Updater written in Rust"
DESCRIPTION = "Rust-basierte Anwendung für RAUC-Updates"
HOMEPAGE = "https://github.com/Climber1987muc/rauc-updater"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f6a8a81aaacfead07ed85bbe4eeed378"

inherit cargo
inherit openrc

# Entweder feste Revision:
# SRCREV = "abcdef1234567890..."
# oder für Entwicklung:
SRCREV = "7c2712233b24192af4c72b429f7afb95ca76fb2c"

S = "${WORKDIR}/git"


RDEPENDS:${PN} += "openrc"


CARGO_DISABLE_NETWORK = "0"
CARGO_FROZEN = "0"
do_configure[network] = "1"
do_compile[network] = "1"

# Git via SSH
SRC_URI = "git://github.com/Climber1987muc/rauc-updater.git;branch=main;protocol=ssh;user=git"


# Cargo-Source-Verzeichnis (normalerweise das Repo-Root)
#CARGO_SRC_DIR = "${S}"

# Optional: falls dein Binary anders heißt als der Paketname:
# CARGO_BUILD_FLAGS += "--bin rauc-updater"

# Install-Schritt: Binary nach ${bindir} kopieren
do_install() {
    install -d ${D}${bindir}
    install -m 0755 \
        ${B}/target/aarch64-oe-linux-musl/release/rauc-agent \
        ${D}${bindir}/rauc-agent
        install -d ${D}${sysconfdir}/rauc-agent
	install -m 0644 \
        ${S}/conf/conf.json \
        ${D}${sysconfdir}/rauc-agent/conf.json
        openrc_install_initd ${S}/service/rauc-agent.initd
}


OPENRC_SERVICES:${PN}      = " rauc-agent "
OPENRC_AUTO_ENABLE:${PN}   = "enable"


# Pakete
RDEPENDS:${PN} = ""
