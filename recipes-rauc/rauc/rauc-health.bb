SUMMARY = "RAUC Updater written in Rust"
DESCRIPTION = "Rust-basierte Anwendung für RAUC-Updates"
HOMEPAGE = "https://github.com/Climber1987muc/rauc-marker-service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f6a8a81aaacfead07ed85bbe4eeed378"

inherit cargo openrc
DEPENDS += "cargo-native rust-native rpm-native"

RDEPENDS:${PN} += "openrc"
PACKAGE_TOOLCHAIN_PROPERTY:append = " no-rpm"
# Überspringt die automatische Suche nach Shared Libraries
EXCLUDE_FROM_SHLIBS = "1"

# Ignoriert QA-Fehler, falls das Binary "stripped" ist oder andere Analysen fehlschlagen
INSANE_SKIP:${PN} += "already-stripped dev-so ldflags"


# Verhindert den Absturz von rpmdeps bei musl-Binärdateien

# Deaktiviert die automatische Generierung von Runtime-Abhängigkeiten via RPM
# Dies löst den "exit status 127" Fehler
SHLIBS_IGNORE_EV = "1"
do_package_qa[noexec] = "1"


# Cargo darf ins Internet (crates.io etc.)
CARGO_DISABLE_NETWORK = "0"

# BitBake: diese Tasks dürfen Netzwerk benutzen
do_configure[network] = "1"
do_compile[network] = "1"
CARGO_FROZEN = "0"

# Git via SSH
SRC_URI = "git://github.com/Climber1987muc/rauc-marker.git;branch=main;protocol=ssh;user=git"

SRC_URI += " \
    crate://crates.io/aho-corasick/1.1.4 \
    crate://crates.io/allocator-api2/0.2.21 \
    crate://crates.io/anstream/0.6.21 \
    crate://crates.io/anstyle/1.0.13 \
    crate://crates.io/anstyle-parse/0.2.7 \
    crate://crates.io/anstyle-query/1.1.5 \
    crate://crates.io/anstyle-wincon/3.0.11 \
    crate://crates.io/anyhow/1.0.100 \
    crate://crates.io/bitflags/2.10.0 \
    crate://crates.io/cfg-if/1.0.4 \
    crate://crates.io/clap/4.5.47 \
    crate://crates.io/clap_builder/4.5.47 \
    crate://crates.io/clap_derive/4.5.47 \
    crate://crates.io/clap_lex/0.7.6 \
    crate://crates.io/colorchoice/1.0.4 \
    crate://crates.io/env_filter/0.1.3 \
    crate://crates.io/env_logger/0.11.8 \
    crate://crates.io/equivalent/1.0.2 \
    crate://crates.io/errno/0.3.14 \
    crate://crates.io/fastrand/2.3.0 \
    crate://crates.io/foldhash/0.1.5 \
    crate://crates.io/foldhash/0.2.0 \
    crate://crates.io/futures/0.3.31 \
    crate://crates.io/futures-channel/0.3.31 \
    crate://crates.io/futures-core/0.3.31 \
    crate://crates.io/futures-executor/0.3.31 \
    crate://crates.io/futures-io/0.3.31 \
    crate://crates.io/futures-macro/0.3.31 \
    crate://crates.io/futures-sink/0.3.31 \
    crate://crates.io/futures-task/0.3.31 \
    crate://crates.io/futures-util/0.3.31 \
    crate://crates.io/getrandom/0.3.4 \
    crate://crates.io/hashbrown/0.15.5 \
    crate://crates.io/hashbrown/0.16.1 \
    crate://crates.io/heck/0.5.0 \
    crate://crates.io/id-arena/2.2.1 \
    crate://crates.io/indexmap/2.12.1 \
    crate://crates.io/is_terminal_polyfill/1.70.2 \
    crate://crates.io/itoa/1.0.17 \
    crate://crates.io/jiff/0.2.16 \
    crate://crates.io/jiff-static/0.2.16 \
    crate://crates.io/jiff-tzdb/0.1.5 \
    crate://crates.io/jiff-tzdb-platform/0.1.3 \
    crate://crates.io/leb128fmt/0.1.0 \
    crate://crates.io/libc/0.2.178 \
    crate://crates.io/linux-raw-sys/0.11.0 \
    crate://crates.io/log/0.4.29 \
    crate://crates.io/memchr/2.7.6 \
    crate://crates.io/once_cell/1.21.3 \
    crate://crates.io/once_cell_polyfill/1.70.2 \
    crate://crates.io/pin-project-lite/0.2.16 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/portable-atomic/1.11.1 \
    crate://crates.io/portable-atomic-util/0.2.4 \
    crate://crates.io/prettyplease/0.2.37 \
    crate://crates.io/proc-macro2/1.0.104 \
    crate://crates.io/quote/1.0.42 \
    crate://crates.io/r-efi/5.3.0 \
    crate://crates.io/regex/1.12.2 \
    crate://crates.io/regex-automata/0.4.13 \
    crate://crates.io/regex-syntax/0.8.8 \
    crate://crates.io/rustix/1.1.3 \
    crate://crates.io/semver/1.0.27 \
    crate://crates.io/serde/1.0.228 \
    crate://crates.io/serde_core/1.0.228 \
    crate://crates.io/serde_derive/1.0.228 \
    crate://crates.io/serde_json/1.0.148 \
    crate://crates.io/serde_spanned/0.6.9 \
    crate://crates.io/slab/0.4.11 \
    crate://crates.io/strsim/0.11.1 \
    crate://crates.io/syn/2.0.111 \
    crate://crates.io/tempfile/3.23.0 \
    crate://crates.io/toml/0.8.23 \
    crate://crates.io/toml_datetime/0.6.11 \
    crate://crates.io/toml_edit/0.22.27 \
    crate://crates.io/toml_write/0.1.2 \
    crate://crates.io/unicode-ident/1.0.22 \
    crate://crates.io/unicode-xid/0.2.6 \
    crate://crates.io/utf8parse/0.2.2 \
    crate://crates.io/wasip2/1.0.1+wasi-0.2.4 \
    crate://crates.io/wasm-encoder/0.239.0 \
    crate://crates.io/wasm-metadata/0.239.0 \
    crate://crates.io/wasmparser/0.239.0 \
    crate://crates.io/windows-link/0.2.1 \
    crate://crates.io/windows-sys/0.61.2 \
    crate://crates.io/winnow/0.7.14 \
    crate://crates.io/wit-bindgen/0.46.0 \
    crate://crates.io/wit-bindgen-core/0.46.0 \
    crate://crates.io/wit-bindgen-rust/0.46.0 \
    crate://crates.io/wit-bindgen-rust-macro/0.46.0 \
    crate://crates.io/wit-component/0.239.0 \
    crate://crates.io/wit-parser/0.239.0 \
    crate://crates.io/zmij/1.0.3 \
"

SRC_URI[aho-corasick-1.1.4.sha256sum] = "ddd31a130427c27518df266943a5308ed92d4b226cc639f5a8f1002816174301"
SRC_URI[allocator-api2-0.2.21.sha256sum] = "683d7910e743518b0e34f1186f92494becacb047c7b6bf616c96772180fef923"
SRC_URI[anstream-0.6.21.sha256sum] = "43d5b281e737544384e969a5ccad3f1cdd24b48086a0fc1b2a5262a26b8f4f4a"
SRC_URI[anstyle-1.0.13.sha256sum] = "5192cca8006f1fd4f7237516f40fa183bb07f8fbdfedaa0036de5ea9b0b45e78"
SRC_URI[anstyle-parse-0.2.7.sha256sum] = "4e7644824f0aa2c7b9384579234ef10eb7efb6a0deb83f9630a49594dd9c15c2"
SRC_URI[anstyle-query-1.1.5.sha256sum] = "40c48f72fd53cd289104fc64099abca73db4166ad86ea0b4341abe65af83dadc"
SRC_URI[anstyle-wincon-3.0.11.sha256sum] = "291e6a250ff86cd4a820112fb8898808a366d8f9f58ce16d1f538353ad55747d"
SRC_URI[anyhow-1.0.100.sha256sum] = "a23eb6b1614318a8071c9b2521f36b424b2c83db5eb3a0fead4a6c0809af6e61"
SRC_URI[bitflags-2.10.0.sha256sum] = "812e12b5285cc515a9c72a5c1d3b6d46a19dac5acfef5265968c166106e31dd3"
SRC_URI[cfg-if-1.0.4.sha256sum] = "9330f8b2ff13f34540b44e946ef35111825727b38d33286ef986142615121801"
SRC_URI[clap-4.5.47.sha256sum] = "7eac00902d9d136acd712710d71823fb8ac8004ca445a89e73a41d45aa712931"
SRC_URI[clap_builder-4.5.47.sha256sum] = "2ad9bbf750e73b5884fb8a211a9424a1906c1e156724260fdae972f31d70e1d6"
SRC_URI[clap_derive-4.5.47.sha256sum] = "bbfd7eae0b0f1a6e63d4b13c9c478de77c2eb546fba158ad50b4203dc24b9f9c"
SRC_URI[clap_lex-0.7.6.sha256sum] = "a1d728cc89cf3aee9ff92b05e62b19ee65a02b5702cff7d5a377e32c6ae29d8d"
SRC_URI[colorchoice-1.0.4.sha256sum] = "b05b61dc5112cbb17e4b6cd61790d9845d13888356391624cbe7e41efeac1e75"
SRC_URI[env_filter-0.1.3.sha256sum] = "186e05a59d4c50738528153b83b0b0194d3a29507dfec16eccd4b342903397d0"
SRC_URI[env_logger-0.11.8.sha256sum] = "13c863f0904021b108aa8b2f55046443e6b1ebde8fd4a15c399893aae4fa069f"
SRC_URI[equivalent-1.0.2.sha256sum] = "877a4ace8713b0bcf2a4e7eec82529c029f1d0619886d18145fea96c3ffe5c0f"
SRC_URI[errno-0.3.14.sha256sum] = "39cab71617ae0d63f51a36d69f866391735b51691dbda63cf6f96d042b63efeb"
SRC_URI[fastrand-2.3.0.sha256sum] = "37909eebbb50d72f9059c3b6d82c0463f2ff062c9e95845c43a6c9c0355411be"
SRC_URI[foldhash-0.1.5.sha256sum] = "d9c4f5dac5e15c24eb999c26181a6ca40b39fe946cbe4c263c7209467bc83af2"
SRC_URI[foldhash-0.2.0.sha256sum] = "77ce24cb58228fbb8aa041425bb1050850ac19177686ea6e0f41a70416f56fdb"
SRC_URI[futures-0.3.31.sha256sum] = "65bc07b1a8bc7c85c5f2e110c476c7389b4554ba72af57d8445ea63a576b0876"
SRC_URI[futures-channel-0.3.31.sha256sum] = "2dff15bf788c671c1934e366d07e30c1814a8ef514e1af724a602e8a2fbe1b10"
SRC_URI[futures-core-0.3.31.sha256sum] = "05f29059c0c2090612e8d742178b0580d2dc940c837851ad723096f87af6663e"
SRC_URI[futures-executor-0.3.31.sha256sum] = "1e28d1d997f585e54aebc3f97d39e72338912123a67330d723fdbb564d646c9f"
SRC_URI[futures-io-0.3.31.sha256sum] = "9e5c1b78ca4aae1ac06c48a526a655760685149f0d465d21f37abfe57ce075c6"
SRC_URI[futures-macro-0.3.31.sha256sum] = "162ee34ebcb7c64a8abebc059ce0fee27c2262618d7b60ed8faf72fef13c3650"
SRC_URI[futures-sink-0.3.31.sha256sum] = "e575fab7d1e0dcb8d0c7bcf9a63ee213816ab51902e6d244a95819acacf1d4f7"
SRC_URI[futures-task-0.3.31.sha256sum] = "f90f7dce0722e95104fcb095585910c0977252f286e354b5e3bd38902cd99988"
SRC_URI[futures-util-0.3.31.sha256sum] = "9fa08315bb612088cc391249efdc3bc77536f16c91f6cf495e6fbe85b20a4a81"
SRC_URI[getrandom-0.3.4.sha256sum] = "899def5c37c4fd7b2664648c28120ecec138e4d395b459e5ca34f9cce2dd77fd"
SRC_URI[hashbrown-0.15.5.sha256sum] = "9229cfe53dfd69f0609a49f65461bd93001ea1ef889cd5529dd176593f5338a1"
SRC_URI[hashbrown-0.16.1.sha256sum] = "841d1cc9bed7f9236f321df977030373f4a4163ae1a7dbfe1a51a2c1a51d9100"
SRC_URI[heck-0.5.0.sha256sum] = "2304e00983f87ffb38b55b444b5e3b60a884b5d30c0fca7d82fe33449bbe55ea"
SRC_URI[id-arena-2.2.1.sha256sum] = "25a2bc672d1148e28034f176e01fffebb08b35768468cc954630da77a1449005"
SRC_URI[indexmap-2.12.1.sha256sum] = "0ad4bb2b565bca0645f4d68c5c9af97fba094e9791da685bf83cb5f3ce74acf2"
SRC_URI[is_terminal_polyfill-1.70.2.sha256sum] = "a6cb138bb79a146c1bd460005623e142ef0181e3d0219cb493e02f7d08a35695"
SRC_URI[itoa-1.0.17.sha256sum] = "92ecc6618181def0457392ccd0ee51198e065e016d1d527a7ac1b6dc7c1f09d2"
SRC_URI[jiff-0.2.16.sha256sum] = "49cce2b81f2098e7e3efc35bc2e0a6b7abec9d34128283d7a26fa8f32a6dbb35"
SRC_URI[jiff-static-0.2.16.sha256sum] = "980af8b43c3ad5d8d349ace167ec8170839f753a42d233ba19e08afe1850fa69"
SRC_URI[jiff-tzdb-0.1.5.sha256sum] = "68971ebff725b9e2ca27a601c5eb38a4c5d64422c4cbab0c535f248087eda5c2"
SRC_URI[jiff-tzdb-platform-0.1.3.sha256sum] = "875a5a69ac2bab1a891711cf5eccbec1ce0341ea805560dcd90b7a2e925132e8"
SRC_URI[leb128fmt-0.1.0.sha256sum] = "09edd9e8b54e49e587e4f6295a7d29c3ea94d469cb40ab8ca70b288248a81db2"
SRC_URI[libc-0.2.178.sha256sum] = "37c93d8daa9d8a012fd8ab92f088405fb202ea0b6ab73ee2482ae66af4f42091"
SRC_URI[linux-raw-sys-0.11.0.sha256sum] = "df1d3c3b53da64cf5760482273a98e575c651a67eec7f77df96b5b642de8f039"
SRC_URI[log-0.4.29.sha256sum] = "5e5032e24019045c762d3c0f28f5b6b8bbf38563a65908389bf7978758920897"
SRC_URI[memchr-2.7.6.sha256sum] = "f52b00d39961fc5b2736ea853c9cc86238e165017a493d1d5c8eac6bdc4cc273"
SRC_URI[once_cell-1.21.3.sha256sum] = "42f5e15c9953c5e4ccceeb2e7382a716482c34515315f7b03532b8b4e8393d2d"
SRC_URI[once_cell_polyfill-1.70.2.sha256sum] = "384b8ab6d37215f3c5301a95a4accb5d64aa607f1fcb26a11b5303878451b4fe"
SRC_URI[pin-project-lite-0.2.16.sha256sum] = "3b3cff922bd51709b605d9ead9aa71031d81447142d828eb4a6eba76fe619f9b"
SRC_URI[pin-utils-0.1.0.sha256sum] = "8b870d8c151b6f2fb93e84a13146138f05d02ed11c7e7c54f8826aaaf7c9f184"
SRC_URI[portable-atomic-1.11.1.sha256sum] = "f84267b20a16ea918e43c6a88433c2d54fa145c92a811b5b047ccbe153674483"
SRC_URI[portable-atomic-util-0.2.4.sha256sum] = "d8a2f0d8d040d7848a709caf78912debcc3f33ee4b3cac47d73d1e1069e83507"
SRC_URI[prettyplease-0.2.37.sha256sum] = "479ca8adacdd7ce8f1fb39ce9ecccbfe93a3f1344b3d0d97f20bc0196208f62b"
SRC_URI[proc-macro2-1.0.104.sha256sum] = "9695f8df41bb4f3d222c95a67532365f569318332d03d5f3f67f37b20e6ebdf0"
SRC_URI[quote-1.0.42.sha256sum] = "a338cc41d27e6cc6dce6cefc13a0729dfbb81c262b1f519331575dd80ef3067f"
SRC_URI[r-efi-5.3.0.sha256sum] = "69cdb34c158ceb288df11e18b4bd39de994f6657d83847bdffdbd7f346754b0f"
SRC_URI[regex-1.12.2.sha256sum] = "843bc0191f75f3e22651ae5f1e72939ab2f72a4bc30fa80a066bd66edefc24d4"
SRC_URI[regex-automata-0.4.13.sha256sum] = "5276caf25ac86c8d810222b3dbb938e512c55c6831a10f3e6ed1c93b84041f1c"
SRC_URI[regex-syntax-0.8.8.sha256sum] = "7a2d987857b319362043e95f5353c0535c1f58eec5336fdfcf626430af7def58"
SRC_URI[rustix-1.1.3.sha256sum] = "146c9e247ccc180c1f61615433868c99f3de3ae256a30a43b49f67c2d9171f34"
SRC_URI[semver-1.0.27.sha256sum] = "d767eb0aabc880b29956c35734170f26ed551a859dbd361d140cdbeca61ab1e2"
SRC_URI[serde-1.0.228.sha256sum] = "9a8e94ea7f378bd32cbbd37198a4a91436180c5bb472411e48b5ec2e2124ae9e"
SRC_URI[serde_core-1.0.228.sha256sum] = "41d385c7d4ca58e59fc732af25c3983b67ac852c1a25000afe1175de458b67ad"
SRC_URI[serde_derive-1.0.228.sha256sum] = "d540f220d3187173da220f885ab66608367b6574e925011a9353e4badda91d79"
SRC_URI[serde_json-1.0.148.sha256sum] = "3084b546a1dd6289475996f182a22aba973866ea8e8b02c51d9f46b1336a22da"
SRC_URI[serde_spanned-0.6.9.sha256sum] = "bf41e0cfaf7226dca15e8197172c295a782857fcb97fad1808a166870dee75a3"
SRC_URI[slab-0.4.11.sha256sum] = "7a2ae44ef20feb57a68b23d846850f861394c2e02dc425a50098ae8c90267589"
SRC_URI[strsim-0.11.1.sha256sum] = "7da8b5736845d9f2fcb837ea5d9e2628564b3b043a70948a3f0b778838c5fb4f"
SRC_URI[syn-2.0.111.sha256sum] = "390cc9a294ab71bdb1aa2e99d13be9c753cd2d7bd6560c77118597410c4d2e87"
SRC_URI[tempfile-3.23.0.sha256sum] = "2d31c77bdf42a745371d260a26ca7163f1e0924b64afa0b688e61b5a9fa02f16"
SRC_URI[toml-0.8.23.sha256sum] = "dc1beb996b9d83529a9e75c17a1686767d148d70663143c7854d8b4a09ced362"
SRC_URI[toml_datetime-0.6.11.sha256sum] = "22cddaf88f4fbc13c51aebbf5f8eceb5c7c5a9da2ac40a13519eb5b0a0e8f11c"
SRC_URI[toml_edit-0.22.27.sha256sum] = "41fe8c660ae4257887cf66394862d21dbca4a6ddd26f04a3560410406a2f819a"
SRC_URI[toml_write-0.1.2.sha256sum] = "5d99f8c9a7727884afe522e9bd5edbfc91a3312b36a77b5fb8926e4c31a41801"
SRC_URI[unicode-ident-1.0.22.sha256sum] = "9312f7c4f6ff9069b165498234ce8be658059c6728633667c526e27dc2cf1df5"
SRC_URI[unicode-xid-0.2.6.sha256sum] = "ebc1c04c71510c7f702b52b7c350734c9ff1295c464a03335b00bb84fc54f853"
SRC_URI[utf8parse-0.2.2.sha256sum] = "06abde3611657adf66d383f00b093d7faecc7fa57071cce2578660c9f1010821"
SRC_URI[wasip2-1.0.1+wasi-0.2.4.sha256sum] = "0562428422c63773dad2c345a1882263bbf4d65cf3f42e90921f787ef5ad58e7"
SRC_URI[wasm-encoder-0.239.0.sha256sum] = "5be00faa2b4950c76fe618c409d2c3ea5a3c9422013e079482d78544bb2d184c"
SRC_URI[wasm-metadata-0.239.0.sha256sum] = "20b3ec880a9ac69ccd92fbdbcf46ee833071cf09f82bb005b2327c7ae6025ae2"
SRC_URI[wasmparser-0.239.0.sha256sum] = "8c9d90bb93e764f6beabf1d02028c70a2156a6583e63ac4218dd07ef733368b0"
SRC_URI[windows-link-0.2.1.sha256sum] = "f0805222e57f7521d6a62e36fa9163bc891acd422f971defe97d64e70d0a4fe5"
SRC_URI[windows-sys-0.61.2.sha256sum] = "ae137229bcbd6cdf0f7b80a31df61766145077ddf49416a728b02cb3921ff3fc"
SRC_URI[winnow-0.7.14.sha256sum] = "5a5364e9d77fcdeeaa6062ced926ee3381faa2ee02d3eb83a5c27a8825540829"
SRC_URI[wit-bindgen-0.46.0.sha256sum] = "f17a85883d4e6d00e8a97c586de764dabcc06133f7f1d55dce5cdc070ad7fe59"
SRC_URI[wit-bindgen-core-0.46.0.sha256sum] = "cabd629f94da277abc739c71353397046401518efb2c707669f805205f0b9890"
SRC_URI[wit-bindgen-rust-0.46.0.sha256sum] = "9a4232e841089fa5f3c4fc732a92e1c74e1a3958db3b12f1de5934da2027f1f4"
SRC_URI[wit-bindgen-rust-macro-0.46.0.sha256sum] = "1e0d4698c2913d8d9c2b220d116409c3f51a7aa8d7765151b886918367179ee9"
SRC_URI[wit-component-0.239.0.sha256sum] = "88a866b19dba2c94d706ec58c92a4c62ab63e482b4c935d2a085ac94caecb136"
SRC_URI[wit-parser-0.239.0.sha256sum] = "55c92c939d667b7bf0c6bf2d1f67196529758f99a2a45a3355cc56964fd5315d"
SRC_URI[zmij-1.0.3.sha256sum] = "e9747e91771f56fd7893e1164abd78febd14a670ceec257caad15e051de35f06"


# SRCREV = "abcdef1234567890..."
# oder für Entwicklung:
SRCREV = "${AUTOREV}"

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


