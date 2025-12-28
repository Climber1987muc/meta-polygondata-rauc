SUMMARY = "RAUC Updater written in Rust"
DESCRIPTION = "Rust-basierte Anwendung für RAUC-Updates"
HOMEPAGE = "https://github.com/Climber1987muc/rauc-marker-service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f6a8a81aaacfead07ed85bbe4eeed378"

inherit cargo
inherit openrc

RDEPENDS:${PN} += "openrc"


# Cargo darf ins Internet (crates.io etc.)
CARGO_DISABLE_NETWORK = "0"

# BitBake: diese Tasks dürfen Netzwerk benutzen
do_configure[network] = "1"
do_compile[network] = "1"
CARGO_FROZEN = "0"




# Git via SSH
SRC_URI = "git://github.com/Climber1987muc/rauc-marker-service.git;branch=main;protocol=ssh;user=git"

SRC_URI += " \
    crate://crates.io/aho-corasick/1.1.4 \
    crate://crates.io/anstream/0.6.21 \
    crate://crates.io/anstyle/1.0.13 \
    crate://crates.io/anstyle-parse/0.2.7 \
    crate://crates.io/anstyle-query/1.1.5 \
    crate://crates.io/anstyle-wincon/3.0.11 \
    crate://crates.io/anyhow/1.0.100 \
    crate://crates.io/clap/4.5.53 \
    crate://crates.io/clap_builder/4.5.53 \
    crate://crates.io/clap_derive/4.5.49 \
    crate://crates.io/clap_lex/0.7.6 \
    crate://crates.io/colorchoice/1.0.4 \
    crate://crates.io/env_filter/0.1.4 \
    crate://crates.io/env_logger/0.11.8 \
    crate://crates.io/heck/0.5.0 \
    crate://crates.io/is_terminal_polyfill/1.70.2 \
    crate://crates.io/jiff/0.2.16 \
    crate://crates.io/jiff-static/0.2.16 \
    crate://crates.io/log/0.4.28 \
    crate://crates.io/memchr/2.7.6 \
    crate://crates.io/once_cell_polyfill/1.70.2 \
    crate://crates.io/portable-atomic/1.11.1 \
    crate://crates.io/portable-atomic-util/0.2.4 \
    crate://crates.io/proc-macro2/1.0.103 \
    crate://crates.io/quote/1.0.42 \
    crate://crates.io/regex/1.12.2 \
    crate://crates.io/regex-automata/0.4.13 \
    crate://crates.io/regex-syntax/0.8.8 \
    crate://crates.io/serde_core/1.0.228 \
    crate://crates.io/serde_derive/1.0.228 \
    crate://crates.io/strsim/0.11.1 \
    crate://crates.io/syn/2.0.110 \
    crate://crates.io/unicode-ident/1.0.22 \
    crate://crates.io/utf8parse/0.2.2 \
    crate://crates.io/windows-link/0.2.1 \
    crate://crates.io/windows-sys/0.61.2 \
"
SRC_URI[aho-corasick-1.1.4.sha256sum] = "ddd31a130427c27518df266943a5308ed92d4b226cc639f5a8f1002816174301"
SRC_URI[anstream-0.6.21.sha256sum] = "43d5b281e737544384e969a5ccad3f1cdd24b48086a0fc1b2a5262a26b8f4f4a"
SRC_URI[anstyle-1.0.13.sha256sum] = "5192cca8006f1fd4f7237516f40fa183bb07f8fbdfedaa0036de5ea9b0b45e78"
SRC_URI[anstyle-parse-0.2.7.sha256sum] = "4e7644824f0aa2c7b9384579234ef10eb7efb6a0deb83f9630a49594dd9c15c2"
SRC_URI[anstyle-query-1.1.5.sha256sum] = "40c48f72fd53cd289104fc64099abca73db4166ad86ea0b4341abe65af83dadc"
SRC_URI[anstyle-wincon-3.0.11.sha256sum] = "291e6a250ff86cd4a820112fb8898808a366d8f9f58ce16d1f538353ad55747d"
SRC_URI[anyhow-1.0.100.sha256sum] = "a23eb6b1614318a8071c9b2521f36b424b2c83db5eb3a0fead4a6c0809af6e61"
SRC_URI[clap-4.5.53.sha256sum] = "c9e340e012a1bf4935f5282ed1436d1489548e8f72308207ea5df0e23d2d03f8"
SRC_URI[clap_builder-4.5.53.sha256sum] = "d76b5d13eaa18c901fd2f7fca939fefe3a0727a953561fefdf3b2922b8569d00"
SRC_URI[clap_derive-4.5.49.sha256sum] = "2a0b5487afeab2deb2ff4e03a807ad1a03ac532ff5a2cee5d86884440c7f7671"
SRC_URI[clap_lex-0.7.6.sha256sum] = "a1d728cc89cf3aee9ff92b05e62b19ee65a02b5702cff7d5a377e32c6ae29d8d"
SRC_URI[colorchoice-1.0.4.sha256sum] = "b05b61dc5112cbb17e4b6cd61790d9845d13888356391624cbe7e41efeac1e75"
SRC_URI[env_filter-0.1.4.sha256sum] = "1bf3c259d255ca70051b30e2e95b5446cdb8949ac4cd22c0d7fd634d89f568e2"
SRC_URI[env_logger-0.11.8.sha256sum] = "13c863f0904021b108aa8b2f55046443e6b1ebde8fd4a15c399893aae4fa069f"
SRC_URI[heck-0.5.0.sha256sum] = "2304e00983f87ffb38b55b444b5e3b60a884b5d30c0fca7d82fe33449bbe55ea"
SRC_URI[is_terminal_polyfill-1.70.2.sha256sum] = "a6cb138bb79a146c1bd460005623e142ef0181e3d0219cb493e02f7d08a35695"
SRC_URI[jiff-0.2.16.sha256sum] = "49cce2b81f2098e7e3efc35bc2e0a6b7abec9d34128283d7a26fa8f32a6dbb35"
SRC_URI[jiff-static-0.2.16.sha256sum] = "980af8b43c3ad5d8d349ace167ec8170839f753a42d233ba19e08afe1850fa69"
SRC_URI[log-0.4.28.sha256sum] = "34080505efa8e45a4b816c349525ebe327ceaa8559756f0356cba97ef3bf7432"
SRC_URI[memchr-2.7.6.sha256sum] = "f52b00d39961fc5b2736ea853c9cc86238e165017a493d1d5c8eac6bdc4cc273"
SRC_URI[once_cell_polyfill-1.70.2.sha256sum] = "384b8ab6d37215f3c5301a95a4accb5d64aa607f1fcb26a11b5303878451b4fe"
SRC_URI[portable-atomic-1.11.1.sha256sum] = "f84267b20a16ea918e43c6a88433c2d54fa145c92a811b5b047ccbe153674483"
SRC_URI[portable-atomic-util-0.2.4.sha256sum] = "d8a2f0d8d040d7848a709caf78912debcc3f33ee4b3cac47d73d1e1069e83507"
SRC_URI[proc-macro2-1.0.103.sha256sum] = "5ee95bc4ef87b8d5ba32e8b7714ccc834865276eab0aed5c9958d00ec45f49e8"
SRC_URI[quote-1.0.42.sha256sum] = "a338cc41d27e6cc6dce6cefc13a0729dfbb81c262b1f519331575dd80ef3067f"
SRC_URI[regex-1.12.2.sha256sum] = "843bc0191f75f3e22651ae5f1e72939ab2f72a4bc30fa80a066bd66edefc24d4"
SRC_URI[regex-automata-0.4.13.sha256sum] = "5276caf25ac86c8d810222b3dbb938e512c55c6831a10f3e6ed1c93b84041f1c"
SRC_URI[regex-syntax-0.8.8.sha256sum] = "7a2d987857b319362043e95f5353c0535c1f58eec5336fdfcf626430af7def58"
SRC_URI[serde_core-1.0.228.sha256sum] = "41d385c7d4ca58e59fc732af25c3983b67ac852c1a25000afe1175de458b67ad"
SRC_URI[serde_derive-1.0.228.sha256sum] = "d540f220d3187173da220f885ab66608367b6574e925011a9353e4badda91d79"
SRC_URI[strsim-0.11.1.sha256sum] = "7da8b5736845d9f2fcb837ea5d9e2628564b3b043a70948a3f0b778838c5fb4f"
SRC_URI[syn-2.0.110.sha256sum] = "a99801b5bd34ede4cf3fc688c5919368fea4e4814a4664359503e6015b280aea"
SRC_URI[unicode-ident-1.0.22.sha256sum] = "9312f7c4f6ff9069b165498234ce8be658059c6728633667c526e27dc2cf1df5"
SRC_URI[utf8parse-0.2.2.sha256sum] = "06abde3611657adf66d383f00b093d7faecc7fa57071cce2578660c9f1010821"
SRC_URI[windows-link-0.2.1.sha256sum] = "f0805222e57f7521d6a62e36fa9163bc891acd422f971defe97d64e70d0a4fe5"
SRC_URI[windows-sys-0.61.2.sha256sum] = "ae137229bcbd6cdf0f7b80a31df61766145077ddf49416a728b02cb3921ff3fc"


# Entweder feste Revision:
# SRCREV = "abcdef1234567890..."
# oder für Entwicklung:
SRCREV = "2d888434a89a48f7b6e356fa0c0d4d1c8c4d1c36"

S = "${WORKDIR}/git"

# Cargo-Source-Verzeichnis (normalerweise das Repo-Root)
#CARGO_SRC_DIR = "${S}"

# Optional: falls dein Binary anders heißt als der Paketname:
# CARGO_BUILD_FLAGS += "--bin rauc-updater"

# Install-Schritt: Binary nach ${bindir} kopieren
do_install() {
    install -d ${D}${sbindir}
    install -m 0755  ${B}/target/${TARGET_SYS}/release/rauc-health ${D}${sbindir}/rauc-health
    openrc_install_initd ${S}/service/rauc-health.initd
}


OPENRC_SERVICES:${PN}      = " rauc-health "
OPENRC_AUTO_ENABLE:${PN}   = "enable"


