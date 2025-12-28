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


SRC_URI += " \
    crate://crates.io/addr2line/0.24.2 \
    crate://crates.io/adler2/2.0.1 \
    crate://crates.io/anstream/0.6.20 \
    crate://crates.io/anstyle/1.0.11 \
    crate://crates.io/anstyle-parse/0.2.7 \
    crate://crates.io/anstyle-query/1.1.4 \
    crate://crates.io/anstyle-wincon/3.0.10 \
    crate://crates.io/atomic-waker/1.1.2 \
    crate://crates.io/backtrace/0.3.75 \
    crate://crates.io/base64/0.22.1 \
    crate://crates.io/bitflags/2.9.4 \
    crate://crates.io/block-buffer/0.10.4 \
    crate://crates.io/bumpalo/3.19.0 \
    crate://crates.io/bytes/1.10.1 \
    crate://crates.io/cc/1.2.36 \
    crate://crates.io/cfg-if/1.0.3 \
    crate://crates.io/cfg_aliases/0.2.1 \
    crate://crates.io/clap/4.5.47 \
    crate://crates.io/clap_builder/4.5.47 \
    crate://crates.io/clap_derive/4.5.47 \
    crate://crates.io/clap_lex/0.7.5 \
    crate://crates.io/colorchoice/1.0.4 \
    crate://crates.io/cpufeatures/0.2.17 \
    crate://crates.io/crypto-common/0.1.6 \
    crate://crates.io/digest/0.10.7 \
    crate://crates.io/displaydoc/0.2.5 \
    crate://crates.io/find-msvc-tools/0.1.1 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/form_urlencoded/1.2.2 \
    crate://crates.io/futures-channel/0.3.31 \
    crate://crates.io/futures-core/0.3.31 \
    crate://crates.io/futures-io/0.3.31 \
    crate://crates.io/futures-sink/0.3.31 \
    crate://crates.io/futures-task/0.3.31 \
    crate://crates.io/futures-util/0.3.31 \
    crate://crates.io/generic-array/0.14.7 \
    crate://crates.io/getrandom/0.2.16 \
    crate://crates.io/getrandom/0.3.3 \
    crate://crates.io/gimli/0.31.1 \
    crate://crates.io/heck/0.5.0 \
    crate://crates.io/hex/0.4.3 \
    crate://crates.io/http/1.3.1 \
    crate://crates.io/http-body/1.0.1 \
    crate://crates.io/http-body-util/0.1.3 \
    crate://crates.io/httparse/1.10.1 \
    crate://crates.io/hyper/1.7.0 \
    crate://crates.io/hyper-rustls/0.27.7 \
    crate://crates.io/hyper-util/0.1.16 \
    crate://crates.io/icu_collections/2.0.0 \
    crate://crates.io/icu_locale_core/2.0.0 \
    crate://crates.io/icu_normalizer/2.0.0 \
    crate://crates.io/icu_normalizer_data/2.0.0 \
    crate://crates.io/icu_properties/2.0.1 \
    crate://crates.io/icu_properties_data/2.0.1 \
    crate://crates.io/icu_provider/2.0.0 \
    crate://crates.io/idna/1.1.0 \
    crate://crates.io/idna_adapter/1.2.1 \
    crate://crates.io/io-uring/0.7.10 \
    crate://crates.io/ipnet/2.11.0 \
    crate://crates.io/iri-string/0.7.8 \
    crate://crates.io/is_terminal_polyfill/1.70.1 \
    crate://crates.io/itoa/1.0.15 \
    crate://crates.io/js-sys/0.3.78 \
    crate://crates.io/libc/0.2.175 \
    crate://crates.io/litemap/0.8.0 \
    crate://crates.io/log/0.4.28 \
    crate://crates.io/lru-slab/0.1.2 \
    crate://crates.io/memchr/2.7.5 \
    crate://crates.io/miniz_oxide/0.8.9 \
    crate://crates.io/mio/1.0.4 \
    crate://crates.io/object/0.36.7 \
    crate://crates.io/once_cell/1.21.3 \
    crate://crates.io/once_cell_polyfill/1.70.1 \
    crate://crates.io/percent-encoding/2.3.2 \
    crate://crates.io/pin-project-lite/0.2.16 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/potential_utf/0.1.3 \
    crate://crates.io/ppv-lite86/0.2.21 \
    crate://crates.io/proc-macro2/1.0.101 \
    crate://crates.io/r-efi/5.3.0 \
    crate://crates.io/rand/0.9.2 \
    crate://crates.io/rand_chacha/0.9.0 \
    crate://crates.io/rand_core/0.9.3 \
    crate://crates.io/reqwest/0.12.23 \
    crate://crates.io/ring/0.17.14 \
    crate://crates.io/rustc-demangle/0.1.26 \
    crate://crates.io/rustc-hash/2.1.1 \
    crate://crates.io/rustls/0.23.31 \
    crate://crates.io/rustls-pki-types/1.12.0 \
    crate://crates.io/rustls-webpki/0.103.4 \
    crate://crates.io/rustversion/1.0.22 \
    crate://crates.io/ryu/1.0.20 \
    crate://crates.io/serde/1.0.219 \
    crate://crates.io/serde_derive/1.0.219 \
    crate://crates.io/serde_json/1.0.143 \
    crate://crates.io/serde_urlencoded/0.7.1 \
    crate://crates.io/sha2/0.10.9 \
    crate://crates.io/shlex/1.3.0 \
    crate://crates.io/slab/0.4.11 \
    crate://crates.io/smallvec/1.15.1 \
    crate://crates.io/socket2/0.6.0 \
    crate://crates.io/stable_deref_trait/1.2.0 \
    crate://crates.io/strsim/0.11.1 \
    crate://crates.io/subtle/2.6.1 \
    crate://crates.io/syn/2.0.106 \
    crate://crates.io/sync_wrapper/1.0.2 \
    crate://crates.io/synstructure/0.13.2 \
    crate://crates.io/thiserror/1.0.69 \
    crate://crates.io/thiserror/2.0.16 \
    crate://crates.io/thiserror-impl/1.0.69 \
    crate://crates.io/thiserror-impl/2.0.16 \
    crate://crates.io/tinystr/0.8.1 \
    crate://crates.io/tinyvec/1.10.0 \
    crate://crates.io/tinyvec_macros/0.1.1 \
    crate://crates.io/tokio/1.47.1 \
    crate://crates.io/tokio-rustls/0.26.2 \
    crate://crates.io/tower/0.5.2 \
    crate://crates.io/tower-http/0.6.6 \
    crate://crates.io/tower-layer/0.3.3 \
    crate://crates.io/tower-service/0.3.3 \
    crate://crates.io/tracing/0.1.41 \
    crate://crates.io/tracing-core/0.1.34 \
    crate://crates.io/try-lock/0.2.5 \
    crate://crates.io/typenum/1.18.0 \
    crate://crates.io/unicode-ident/1.0.18 \
    crate://crates.io/untrusted/0.9.0 \
    crate://crates.io/url/2.5.7 \
    crate://crates.io/utf8_iter/1.0.4 \
    crate://crates.io/utf8parse/0.2.2 \
    crate://crates.io/version_check/0.9.5 \
    crate://crates.io/want/0.3.1 \
    crate://crates.io/wasi/0.11.1+wasi-snapshot-preview1 \
    crate://crates.io/wasi/0.14.5+wasi-0.2.4 \
    crate://crates.io/wasip2/1.0.0+wasi-0.2.4 \
    crate://crates.io/wasm-bindgen/0.2.101 \
    crate://crates.io/wasm-bindgen-backend/0.2.101 \
    crate://crates.io/wasm-bindgen-futures/0.4.51 \
    crate://crates.io/wasm-bindgen-macro/0.2.101 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.101 \
    crate://crates.io/wasm-bindgen-shared/0.2.101 \
    crate://crates.io/web-sys/0.3.78 \
    crate://crates.io/web-time/1.1.0 \
    crate://crates.io/webpki-roots/1.0.2 \
    crate://crates.io/windows-link/0.1.3 \
    crate://crates.io/windows-sys/0.52.0 \
    crate://crates.io/windows-sys/0.59.0 \
    crate://crates.io/windows-sys/0.60.2 \
    crate://crates.io/windows-targets/0.52.6 \
    crate://crates.io/windows-targets/0.53.3 \
    crate://crates.io/windows_aarch64_gnullvm/0.52.6 \
    crate://crates.io/windows_aarch64_gnullvm/0.53.0 \
    crate://crates.io/windows_aarch64_msvc/0.52.6 \
    crate://crates.io/windows_aarch64_msvc/0.53.0 \
    crate://crates.io/windows_i686_gnu/0.52.6 \
    crate://crates.io/windows_i686_gnu/0.53.0 \
    crate://crates.io/windows_i686_gnullvm/0.52.6 \
    crate://crates.io/windows_i686_gnullvm/0.53.0 \
    crate://crates.io/windows_i686_msvc/0.52.6 \
    crate://crates.io/windows_i686_msvc/0.53.0 \
    crate://crates.io/windows_x86_64_gnu/0.52.6 \
    crate://crates.io/windows_x86_64_gnu/0.53.0 \
    crate://crates.io/windows_x86_64_gnullvm/0.52.6 \
    crate://crates.io/windows_x86_64_gnullvm/0.53.0 \
    crate://crates.io/windows_x86_64_msvc/0.52.6 \
    crate://crates.io/windows_x86_64_msvc/0.53.0 \
    crate://crates.io/wit-bindgen/0.45.1 \
    crate://crates.io/writeable/0.6.1 \
    crate://crates.io/yoke/0.8.0 \
    crate://crates.io/yoke-derive/0.8.0 \
    crate://crates.io/zerocopy/0.8.27 \
    crate://crates.io/zerocopy-derive/0.8.27 \
    crate://crates.io/zerofrom/0.1.6 \
    crate://crates.io/zerofrom-derive/0.1.6 \
    crate://crates.io/zeroize/1.8.1 \
    crate://crates.io/zerotrie/0.2.2 \
    crate://crates.io/zerovec/0.11.4 \
    crate://crates.io/zerovec-derive/0.11.1 \
    crate://crates.io/quinn/0.11.9 \
    crate://crates.io/quinn-proto/0.11.13 \
    crate://crates.io/quinn-udp/0.5.14 \
    crate://crates.io/proc-macro2/1.0.101 \
    crate://crates.io/quote/1.0.40 \
    crate://crates.io/syn/2.0.106 \
"


SRC_URI[quinn-0.11.9.sha256sum] = "b9e20a958963c291dc322d98411f541009df2ced7b5a4f2bd52337638cfccf20"
SRC_URI[quinn-proto-0.11.13.sha256sum] = "f1906b49b0c3bc04b5fe5d86a77925ae6524a19b816ae38ce1e426255f1d8a31"
SRC_URI[quinn-udp-0.5.14.sha256sum] = "addec6a0dcad8a8d96a771f815f0eaf55f9d1805756410b39f5fa81332574cbd"
SRC_URI[quote-1.0.40.sha256sum] = "1885c039570dc00dcb4ff087a89e185fd56bae234ddc7f056a945bf36467248d"
SRC_URI[addr2line-0.24.2.sha256sum] = "dfbe277e56a376000877090da837660b4427aad530e3028d44e0bffe4f89a1c1"
SRC_URI[adler2-2.0.1.sha256sum] = "320119579fcad9c21884f5c4861d16174d0e06250625266f50fe6898340abefa"
SRC_URI[anstream-0.6.20.sha256sum] = "3ae563653d1938f79b1ab1b5e668c87c76a9930414574a6583a7b7e11a8e6192"
SRC_URI[anstyle-1.0.11.sha256sum] = "862ed96ca487e809f1c8e5a8447f6ee2cf102f846893800b20cebdf541fc6bbd"
SRC_URI[anstyle-parse-0.2.7.sha256sum] = "4e7644824f0aa2c7b9384579234ef10eb7efb6a0deb83f9630a49594dd9c15c2"
SRC_URI[anstyle-query-1.1.4.sha256sum] = "9e231f6134f61b71076a3eab506c379d4f36122f2af15a9ff04415ea4c3339e2"
SRC_URI[anstyle-wincon-3.0.10.sha256sum] = "3e0633414522a32ffaac8ac6cc8f748e090c5717661fddeea04219e2344f5f2a"
SRC_URI[atomic-waker-1.1.2.sha256sum] = "1505bd5d3d116872e7271a6d4e16d81d0c8570876c8de68093a09ac269d8aac0"
SRC_URI[backtrace-0.3.75.sha256sum] = "6806a6321ec58106fea15becdad98371e28d92ccbc7c8f1b3b6dd724fe8f1002"
SRC_URI[base64-0.22.1.sha256sum] = "72b3254f16251a8381aa12e40e3c4d2f0199f8c6508fbecb9d91f575e0fbb8c6"
SRC_URI[bitflags-2.9.4.sha256sum] = "2261d10cca569e4643e526d8dc2e62e433cc8aba21ab764233731f8d369bf394"
SRC_URI[block-buffer-0.10.4.sha256sum] = "3078c7629b62d3f0439517fa394996acacc5cbc91c5a20d8c658e77abd503a71"
SRC_URI[bumpalo-3.19.0.sha256sum] = "46c5e41b57b8bba42a04676d81cb89e9ee8e859a1a66f80a5a72e1cb76b34d43"
SRC_URI[bytes-1.10.1.sha256sum] = "d71b6127be86fdcfddb610f7182ac57211d4b18a3e9c82eb2d17662f2227ad6a"
SRC_URI[cc-1.2.36.sha256sum] = "5252b3d2648e5eedbc1a6f501e3c795e07025c1e93bbf8bbdd6eef7f447a6d54"
SRC_URI[cfg-if-1.0.3.sha256sum] = "2fd1289c04a9ea8cb22300a459a72a385d7c73d3259e2ed7dcb2af674838cfa9"
SRC_URI[cfg_aliases-0.2.1.sha256sum] = "613afe47fcd5fac7ccf1db93babcb082c5994d996f20b8b159f2ad1658eb5724"
SRC_URI[clap-4.5.47.sha256sum] = "7eac00902d9d136acd712710d71823fb8ac8004ca445a89e73a41d45aa712931"
SRC_URI[clap_builder-4.5.47.sha256sum] = "2ad9bbf750e73b5884fb8a211a9424a1906c1e156724260fdae972f31d70e1d6"
SRC_URI[clap_derive-4.5.47.sha256sum] = "bbfd7eae0b0f1a6e63d4b13c9c478de77c2eb546fba158ad50b4203dc24b9f9c"
SRC_URI[clap_lex-0.7.5.sha256sum] = "b94f61472cee1439c0b966b47e3aca9ae07e45d070759512cd390ea2bebc6675"
SRC_URI[colorchoice-1.0.4.sha256sum] = "b05b61dc5112cbb17e4b6cd61790d9845d13888356391624cbe7e41efeac1e75"
SRC_URI[cpufeatures-0.2.17.sha256sum] = "59ed5838eebb26a2bb2e58f6d5b5316989ae9d08bab10e0e6d103e656d1b0280"
SRC_URI[crypto-common-0.1.6.sha256sum] = "1bfb12502f3fc46cca1bb51ac28df9d618d813cdc3d2f25b9fe775a34af26bb3"
SRC_URI[digest-0.10.7.sha256sum] = "9ed9a281f7bc9b7576e61468ba615a66a5c8cfdff42420a70aa82701a3b1e292"
SRC_URI[displaydoc-0.2.5.sha256sum] = "97369cbbc041bc366949bc74d34658d6cda5621039731c6310521892a3a20ae0"
SRC_URI[find-msvc-tools-0.1.1.sha256sum] = "7fd99930f64d146689264c637b5af2f0233a933bef0d8570e2526bf9e083192d"
SRC_URI[fnv-1.0.7.sha256sum] = "3f9eec918d3f24069decb9af1554cad7c880e2da24a9afd88aca000531ab82c1"
SRC_URI[form_urlencoded-1.2.2.sha256sum] = "cb4cb245038516f5f85277875cdaa4f7d2c9a0fa0468de06ed190163b1581fcf"
SRC_URI[futures-channel-0.3.31.sha256sum] = "2dff15bf788c671c1934e366d07e30c1814a8ef514e1af724a602e8a2fbe1b10"
SRC_URI[futures-core-0.3.31.sha256sum] = "05f29059c0c2090612e8d742178b0580d2dc940c837851ad723096f87af6663e"
SRC_URI[futures-io-0.3.31.sha256sum] = "9e5c1b78ca4aae1ac06c48a526a655760685149f0d465d21f37abfe57ce075c6"
SRC_URI[futures-sink-0.3.31.sha256sum] = "e575fab7d1e0dcb8d0c7bcf9a63ee213816ab51902e6d244a95819acacf1d4f7"
SRC_URI[futures-task-0.3.31.sha256sum] = "f90f7dce0722e95104fcb095585910c0977252f286e354b5e3bd38902cd99988"
SRC_URI[futures-util-0.3.31.sha256sum] = "9fa08315bb612088cc391249efdc3bc77536f16c91f6cf495e6fbe85b20a4a81"
SRC_URI[generic-array-0.14.7.sha256sum] = "85649ca51fd72272d7821adaf274ad91c288277713d9c18820d8499a7ff69e9a"
SRC_URI[getrandom-0.2.16.sha256sum] = "335ff9f135e4384c8150d6f27c6daed433577f86b4750418338c01a1a2528592"
SRC_URI[getrandom-0.3.3.sha256sum] = "26145e563e54f2cadc477553f1ec5ee650b00862f0a58bcd12cbdc5f0ea2d2f4"
SRC_URI[gimli-0.31.1.sha256sum] = "07e28edb80900c19c28f1072f2e8aeca7fa06b23cd4169cefe1af5aa3260783f"
SRC_URI[heck-0.5.0.sha256sum] = "2304e00983f87ffb38b55b444b5e3b60a884b5d30c0fca7d82fe33449bbe55ea"
SRC_URI[hex-0.4.3.sha256sum] = "7f24254aa9a54b5c858eaee2f5bccdb46aaf0e486a595ed5fd8f86ba55232a70"
SRC_URI[http-1.3.1.sha256sum] = "f4a85d31aea989eead29a3aaf9e1115a180df8282431156e533de47660892565"
SRC_URI[http-body-1.0.1.sha256sum] = "1efedce1fb8e6913f23e0c92de8e62cd5b772a67e7b3946df930a62566c93184"
SRC_URI[http-body-util-0.1.3.sha256sum] = "b021d93e26becf5dc7e1b75b1bed1fd93124b374ceb73f43d4d4eafec896a64a"
SRC_URI[httparse-1.10.1.sha256sum] = "6dbf3de79e51f3d586ab4cb9d5c3e2c14aa28ed23d180cf89b4df0454a69cc87"
SRC_URI[hyper-1.7.0.sha256sum] = "eb3aa54a13a0dfe7fbe3a59e0c76093041720fdc77b110cc0fc260fafb4dc51e"
SRC_URI[hyper-rustls-0.27.7.sha256sum] = "e3c93eb611681b207e1fe55d5a71ecf91572ec8a6705cdb6857f7d8d5242cf58"
SRC_URI[hyper-util-0.1.16.sha256sum] = "8d9b05277c7e8da2c93a568989bb6207bef0112e8d17df7a6eda4a3cf143bc5e"
SRC_URI[icu_collections-2.0.0.sha256sum] = "200072f5d0e3614556f94a9930d5dc3e0662a652823904c3a75dc3b0af7fee47"
SRC_URI[icu_locale_core-2.0.0.sha256sum] = "0cde2700ccaed3872079a65fb1a78f6c0a36c91570f28755dda67bc8f7d9f00a"
SRC_URI[icu_normalizer-2.0.0.sha256sum] = "436880e8e18df4d7bbc06d58432329d6458cc84531f7ac5f024e93deadb37979"
SRC_URI[icu_normalizer_data-2.0.0.sha256sum] = "00210d6893afc98edb752b664b8890f0ef174c8adbb8d0be9710fa66fbbf72d3"
SRC_URI[icu_properties-2.0.1.sha256sum] = "016c619c1eeb94efb86809b015c58f479963de65bdb6253345c1a1276f22e32b"
SRC_URI[icu_properties_data-2.0.1.sha256sum] = "298459143998310acd25ffe6810ed544932242d3f07083eee1084d83a71bd632"
SRC_URI[icu_provider-2.0.0.sha256sum] = "03c80da27b5f4187909049ee2d72f276f0d9f99a42c306bd0131ecfe04d8e5af"
SRC_URI[idna-1.1.0.sha256sum] = "3b0875f23caa03898994f6ddc501886a45c7d3d62d04d2d90788d47be1b1e4de"
SRC_URI[idna_adapter-1.2.1.sha256sum] = "3acae9609540aa318d1bc588455225fb2085b9ed0c4f6bd0d9d5bcd86f1a0344"
SRC_URI[io-uring-0.7.10.sha256sum] = "046fa2d4d00aea763528b4950358d0ead425372445dc8ff86312b3c69ff7727b"
SRC_URI[ipnet-2.11.0.sha256sum] = "469fb0b9cefa57e3ef31275ee7cacb78f2fdca44e4765491884a2b119d4eb130"
SRC_URI[iri-string-0.7.8.sha256sum] = "dbc5ebe9c3a1a7a5127f920a418f7585e9e758e911d0466ed004f393b0e380b2"
SRC_URI[is_terminal_polyfill-1.70.1.sha256sum] = "7943c866cc5cd64cbc25b2e01621d07fa8eb2a1a23160ee81ce38704e97b8ecf"
SRC_URI[itoa-1.0.15.sha256sum] = "4a5f13b858c8d314ee3e8f639011f7ccefe71f97f96e50151fb991f267928e2c"
SRC_URI[js-sys-0.3.78.sha256sum] = "0c0b063578492ceec17683ef2f8c5e89121fbd0b172cbc280635ab7567db2738"
SRC_URI[libc-0.2.175.sha256sum] = "6a82ae493e598baaea5209805c49bbf2ea7de956d50d7da0da1164f9c6d28543"
SRC_URI[litemap-0.8.0.sha256sum] = "241eaef5fd12c88705a01fc1066c48c4b36e0dd4377dcdc7ec3942cea7a69956"
SRC_URI[log-0.4.28.sha256sum] = "34080505efa8e45a4b816c349525ebe327ceaa8559756f0356cba97ef3bf7432"
SRC_URI[lru-slab-0.1.2.sha256sum] = "112b39cec0b298b6c1999fee3e31427f74f676e4cb9879ed1a121b43661a4154"
SRC_URI[memchr-2.7.5.sha256sum] = "32a282da65faaf38286cf3be983213fcf1d2e2a58700e808f83f4ea9a4804bc0"
SRC_URI[miniz_oxide-0.8.9.sha256sum] = "1fa76a2c86f704bdb222d66965fb3d63269ce38518b83cb0575fca855ebb6316"
SRC_URI[mio-1.0.4.sha256sum] = "78bed444cc8a2160f01cbcf811ef18cac863ad68ae8ca62092e8db51d51c761c"
SRC_URI[object-0.36.7.sha256sum] = "62948e14d923ea95ea2c7c86c71013138b66525b86bdc08d2dcc262bdb497b87"
SRC_URI[once_cell-1.21.3.sha256sum] = "42f5e15c9953c5e4ccceeb2e7382a716482c34515315f7b03532b8b4e8393d2d"
SRC_URI[once_cell_polyfill-1.70.1.sha256sum] = "a4895175b425cb1f87721b59f0f286c2092bd4af812243672510e1ac53e2e0ad"
SRC_URI[percent-encoding-2.3.2.sha256sum] = "9b4f627cb1b25917193a259e49bdad08f671f8d9708acfd5fe0a8c1455d87220"
SRC_URI[pin-project-lite-0.2.16.sha256sum] = "3b3cff922bd51709b605d9ead9aa71031d81447142d828eb4a6eba76fe619f9b"
SRC_URI[pin-utils-0.1.0.sha256sum] = "8b870d8c151b6f2fb93e84a13146138f05d02ed11c7e7c54f8826aaaf7c9f184"
SRC_URI[potential_utf-0.1.3.sha256sum] = "84df19adbe5b5a0782edcab45899906947ab039ccf4573713735ee7de1e6b08a"
SRC_URI[ppv-lite86-0.2.21.sha256sum] = "85eae3c4ed2f50dcfe72643da4befc30deadb458a9b590d720cde2f2b1e97da9"
SRC_URI[proc-macro2-1.0.101.sha256sum] = "89ae43fd86e4158d6db51ad8e2b80f313af9cc74f5c0e03ccb87de09998732de"
SRC_URI[r-efi-5.3.0.sha256sum] = "69cdb34c158ceb288df11e18b4bd39de994f6657d83847bdffdbd7f346754b0f"
SRC_URI[rand-0.9.2.sha256sum] = "6db2770f06117d490610c7488547d543617b21bfa07796d7a12f6f1bd53850d1"
SRC_URI[rand_chacha-0.9.0.sha256sum] = "d3022b5f1df60f26e1ffddd6c66e8aa15de382ae63b3a0c1bfc0e4d3e3f325cb"
SRC_URI[rand_core-0.9.3.sha256sum] = "99d9a13982dcf210057a8a78572b2217b667c3beacbf3a0d8b454f6f82837d38"
SRC_URI[reqwest-0.12.23.sha256sum] = "d429f34c8092b2d42c7c93cec323bb4adeb7c67698f70839adec842ec10c7ceb"
SRC_URI[ring-0.17.14.sha256sum] = "a4689e6c2294d81e88dc6261c768b63bc4fcdb852be6d1352498b114f61383b7"
SRC_URI[rustc-demangle-0.1.26.sha256sum] = "56f7d92ca342cea22a06f2121d944b4fd82af56988c270852495420f961d4ace"
SRC_URI[rustc-hash-2.1.1.sha256sum] = "357703d41365b4b27c590e3ed91eabb1b663f07c4c084095e60cbed4362dff0d"
SRC_URI[rustls-0.23.31.sha256sum] = "c0ebcbd2f03de0fc1122ad9bb24b127a5a6cd51d72604a3f3c50ac459762b6cc"
SRC_URI[rustls-pki-types-1.12.0.sha256sum] = "229a4a4c221013e7e1f1a043678c5cc39fe5171437c88fb47151a21e6f5b5c79"
SRC_URI[rustls-webpki-0.103.4.sha256sum] = "0a17884ae0c1b773f1ccd2bd4a8c72f16da897310a98b0e84bf349ad5ead92fc"
SRC_URI[rustversion-1.0.22.sha256sum] = "b39cdef0fa800fc44525c84ccb54a029961a8215f9619753635a9c0d2538d46d"
SRC_URI[ryu-1.0.20.sha256sum] = "28d3b2b1366ec20994f1fd18c3c594f05c5dd4bc44d8bb0c1c632c8d6829481f"
SRC_URI[serde-1.0.219.sha256sum] = "5f0e2c6ed6606019b4e29e69dbaba95b11854410e5347d525002456dbbb786b6"
SRC_URI[serde_derive-1.0.219.sha256sum] = "5b0276cf7f2c73365f7157c8123c21cd9a50fbbd844757af28ca1f5925fc2a00"
SRC_URI[serde_json-1.0.143.sha256sum] = "d401abef1d108fbd9cbaebc3e46611f4b1021f714a0597a71f41ee463f5f4a5a"
SRC_URI[serde_urlencoded-0.7.1.sha256sum] = "d3491c14715ca2294c4d6a88f15e84739788c1d030eed8c110436aafdaa2f3fd"
SRC_URI[sha2-0.10.9.sha256sum] = "a7507d819769d01a365ab707794a4084392c824f54a7a6a7862f8c3d0892b283"
SRC_URI[shlex-1.3.0.sha256sum] = "0fda2ff0d084019ba4d7c6f371c95d8fd75ce3524c3cb8fb653a3023f6323e64"
SRC_URI[slab-0.4.11.sha256sum] = "7a2ae44ef20feb57a68b23d846850f861394c2e02dc425a50098ae8c90267589"
SRC_URI[smallvec-1.15.1.sha256sum] = "67b1b7a3b5fe4f1376887184045fcf45c69e92af734b7aaddc05fb777b6fbd03"
SRC_URI[socket2-0.6.0.sha256sum] = "233504af464074f9d066d7b5416c5f9b894a5862a6506e306f7b816cdd6f1807"
SRC_URI[stable_deref_trait-1.2.0.sha256sum] = "a8f112729512f8e442d81f95a8a7ddf2b7c6b8a1a6f509a95864142b30cab2d3"
SRC_URI[strsim-0.11.1.sha256sum] = "7da8b5736845d9f2fcb837ea5d9e2628564b3b043a70948a3f0b778838c5fb4f"
SRC_URI[subtle-2.6.1.sha256sum] = "13c2bddecc57b384dee18652358fb23172facb8a2c51ccc10d74c157bdea3292"
SRC_URI[syn-2.0.106.sha256sum] = "ede7c438028d4436d71104916910f5bb611972c5cfd7f89b8300a8186e6fada6"
SRC_URI[sync_wrapper-1.0.2.sha256sum] = "0bf256ce5efdfa370213c1dabab5935a12e49f2c58d15e9eac2870d3b4f27263"
SRC_URI[synstructure-0.13.2.sha256sum] = "728a70f3dbaf5bab7f0c4b1ac8d7ae5ea60a4b5549c8a5914361c99147a709d2"
SRC_URI[thiserror-1.0.69.sha256sum] = "b6aaf5339b578ea85b50e080feb250a3e8ae8cfcdff9a461c9ec2904bc923f52"
SRC_URI[thiserror-2.0.16.sha256sum] = "3467d614147380f2e4e374161426ff399c91084acd2363eaf549172b3d5e60c0"
SRC_URI[thiserror-impl-1.0.69.sha256sum] = "4fee6c4efc90059e10f81e6d42c60a18f76588c3d74cb83a0b242a2b6c7504c1"
SRC_URI[thiserror-impl-2.0.16.sha256sum] = "6c5e1be1c48b9172ee610da68fd9cd2770e7a4056cb3fc98710ee6906f0c7960"
SRC_URI[tinystr-0.8.1.sha256sum] = "5d4f6d1145dcb577acf783d4e601bc1d76a13337bb54e6233add580b07344c8b"
SRC_URI[tinyvec-1.10.0.sha256sum] = "bfa5fdc3bce6191a1dbc8c02d5c8bffcf557bafa17c124c5264a458f1b0613fa"
SRC_URI[tinyvec_macros-0.1.1.sha256sum] = "1f3ccbac311fea05f86f61904b462b55fb3df8837a366dfc601a0161d0532f20"
SRC_URI[tokio-1.47.1.sha256sum] = "89e49afdadebb872d3145a5638b59eb0691ea23e46ca484037cfab3b76b95038"
SRC_URI[tokio-rustls-0.26.2.sha256sum] = "8e727b36a1a0e8b74c376ac2211e40c2c8af09fb4013c60d910495810f008e9b"
SRC_URI[tower-0.5.2.sha256sum] = "d039ad9159c98b70ecfd540b2573b97f7f52c3e8d9f8ad57a24b916a536975f9"
SRC_URI[tower-http-0.6.6.sha256sum] = "adc82fd73de2a9722ac5da747f12383d2bfdb93591ee6c58486e0097890f05f2"
SRC_URI[tower-layer-0.3.3.sha256sum] = "121c2a6cda46980bb0fcd1647ffaf6cd3fc79a013de288782836f6df9c48780e"
SRC_URI[tower-service-0.3.3.sha256sum] = "8df9b6e13f2d32c91b9bd719c00d1958837bc7dec474d94952798cc8e69eeec3"
SRC_URI[tracing-0.1.41.sha256sum] = "784e0ac535deb450455cbfa28a6f0df145ea1bb7ae51b821cf5e7927fdcfbdd0"
SRC_URI[tracing-core-0.1.34.sha256sum] = "b9d12581f227e93f094d3af2ae690a574abb8a2b9b7a96e7cfe9647b2b617678"
SRC_URI[try-lock-0.2.5.sha256sum] = "e421abadd41a4225275504ea4d6566923418b7f05506fbc9c0fe86ba7396114b"
SRC_URI[typenum-1.18.0.sha256sum] = "1dccffe3ce07af9386bfd29e80c0ab1a8205a2fc34e4bcd40364df902cfa8f3f"
SRC_URI[unicode-ident-1.0.18.sha256sum] = "5a5f39404a5da50712a4c1eecf25e90dd62b613502b7e925fd4e4d19b5c96512"
SRC_URI[untrusted-0.9.0.sha256sum] = "8ecb6da28b8a351d773b68d5825ac39017e680750f980f3a1a85cd8dd28a47c1"
SRC_URI[url-2.5.7.sha256sum] = "08bc136a29a3d1758e07a9cca267be308aeebf5cfd5a10f3f67ab2097683ef5b"
SRC_URI[utf8_iter-1.0.4.sha256sum] = "b6c140620e7ffbb22c2dee59cafe6084a59b5ffc27a8859a5f0d494b5d52b6be"
SRC_URI[utf8parse-0.2.2.sha256sum] = "06abde3611657adf66d383f00b093d7faecc7fa57071cce2578660c9f1010821"
SRC_URI[version_check-0.9.5.sha256sum] = "0b928f33d975fc6ad9f86c8f283853ad26bdd5b10b7f1542aa2fa15e2289105a"
SRC_URI[want-0.3.1.sha256sum] = "bfa7760aed19e106de2c7c0b581b509f2f25d3dacaf737cb82ac61bc6d760b0e"
SRC_URI[wasi-0.11.1+wasi-snapshot-preview1.sha256sum] = "ccf3ec651a847eb01de73ccad15eb7d99f80485de043efb2f370cd654f4ea44b"
SRC_URI[wasi-0.14.5+wasi-0.2.4.sha256sum] = "a4494f6290a82f5fe584817a676a34b9d6763e8d9d18204009fb31dceca98fd4"
SRC_URI[wasip2-1.0.0+wasi-0.2.4.sha256sum] = "03fa2761397e5bd52002cd7e73110c71af2109aca4e521a9f40473fe685b0a24"
SRC_URI[wasm-bindgen-0.2.101.sha256sum] = "7e14915cadd45b529bb8d1f343c4ed0ac1de926144b746e2710f9cd05df6603b"
SRC_URI[wasm-bindgen-backend-0.2.101.sha256sum] = "e28d1ba982ca7923fd01448d5c30c6864d0a14109560296a162f80f305fb93bb"
SRC_URI[wasm-bindgen-futures-0.4.51.sha256sum] = "0ca85039a9b469b38336411d6d6ced91f3fc87109a2a27b0c197663f5144dffe"
SRC_URI[wasm-bindgen-macro-0.2.101.sha256sum] = "7c3d463ae3eff775b0c45df9da45d68837702ac35af998361e2c84e7c5ec1b0d"
SRC_URI[wasm-bindgen-macro-support-0.2.101.sha256sum] = "7bb4ce89b08211f923caf51d527662b75bdc9c9c7aab40f86dcb9fb85ac552aa"
SRC_URI[wasm-bindgen-shared-0.2.101.sha256sum] = "f143854a3b13752c6950862c906306adb27c7e839f7414cec8fea35beab624c1"
SRC_URI[web-sys-0.3.78.sha256sum] = "77e4b637749ff0d92b8fad63aa1f7cff3cbe125fd49c175cd6345e7272638b12"
SRC_URI[web-time-1.1.0.sha256sum] = "5a6580f308b1fad9207618087a65c04e7a10bc77e02c8e84e9b00dd4b12fa0bb"
SRC_URI[webpki-roots-1.0.2.sha256sum] = "7e8983c3ab33d6fb807cfcdad2491c4ea8cbc8ed839181c7dfd9c67c83e261b2"
SRC_URI[windows-link-0.1.3.sha256sum] = "5e6ad25900d524eaabdbbb96d20b4311e1e7ae1699af4fb28c17ae66c80d798a"
SRC_URI[windows-sys-0.52.0.sha256sum] = "282be5f36a8ce781fad8c8ae18fa3f9beff57ec1b52cb3de0789201425d9a33d"
SRC_URI[windows-sys-0.59.0.sha256sum] = "1e38bc4d79ed67fd075bcc251a1c39b32a1776bbe92e5bef1f0bf1f8c531853b"
SRC_URI[windows-sys-0.60.2.sha256sum] = "f2f500e4d28234f72040990ec9d39e3a6b950f9f22d3dba18416c35882612bcb"
SRC_URI[windows-targets-0.52.6.sha256sum] = "9b724f72796e036ab90c1021d4780d4d3d648aca59e491e6b98e725b84e99973"
SRC_URI[windows-targets-0.53.3.sha256sum] = "d5fe6031c4041849d7c496a8ded650796e7b6ecc19df1a431c1a363342e5dc91"
SRC_URI[windows_aarch64_gnullvm-0.52.6.sha256sum] = "32a4622180e7a0ec044bb555404c800bc9fd9ec262ec147edd5989ccd0c02cd3"
SRC_URI[windows_aarch64_gnullvm-0.53.0.sha256sum] = "86b8d5f90ddd19cb4a147a5fa63ca848db3df085e25fee3cc10b39b6eebae764"
SRC_URI[windows_aarch64_msvc-0.52.6.sha256sum] = "09ec2a7bb152e2252b53fa7803150007879548bc709c039df7627cabbd05d469"
SRC_URI[windows_aarch64_msvc-0.53.0.sha256sum] = "c7651a1f62a11b8cbd5e0d42526e55f2c99886c77e007179efff86c2b137e66c"
SRC_URI[windows_i686_gnu-0.52.6.sha256sum] = "8e9b5ad5ab802e97eb8e295ac6720e509ee4c243f69d781394014ebfe8bbfa0b"
SRC_URI[windows_i686_gnu-0.53.0.sha256sum] = "c1dc67659d35f387f5f6c479dc4e28f1d4bb90ddd1a5d3da2e5d97b42d6272c3"
SRC_URI[windows_i686_gnullvm-0.52.6.sha256sum] = "0eee52d38c090b3caa76c563b86c3a4bd71ef1a819287c19d586d7334ae8ed66"
SRC_URI[windows_i686_gnullvm-0.53.0.sha256sum] = "9ce6ccbdedbf6d6354471319e781c0dfef054c81fbc7cf83f338a4296c0cae11"
SRC_URI[windows_i686_msvc-0.52.6.sha256sum] = "240948bc05c5e7c6dabba28bf89d89ffce3e303022809e73deaefe4f6ec56c66"
SRC_URI[windows_i686_msvc-0.53.0.sha256sum] = "581fee95406bb13382d2f65cd4a908ca7b1e4c2f1917f143ba16efe98a589b5d"
SRC_URI[windows_x86_64_gnu-0.52.6.sha256sum] = "147a5c80aabfbf0c7d901cb5895d1de30ef2907eb21fbbab29ca94c5b08b1a78"
SRC_URI[windows_x86_64_gnu-0.53.0.sha256sum] = "2e55b5ac9ea33f2fc1716d1742db15574fd6fc8dadc51caab1c16a3d3b4190ba"
SRC_URI[windows_x86_64_gnullvm-0.52.6.sha256sum] = "24d5b23dc417412679681396f2b49f3de8c1473deb516bd34410872eff51ed0d"
SRC_URI[windows_x86_64_gnullvm-0.53.0.sha256sum] = "0a6e035dd0599267ce1ee132e51c27dd29437f63325753051e71dd9e42406c57"
SRC_URI[windows_x86_64_msvc-0.52.6.sha256sum] = "589f6da84c646204747d1270a2a5661ea66ed1cced2631d546fdfb155959f9ec"
SRC_URI[windows_x86_64_msvc-0.53.0.sha256sum] = "271414315aff87387382ec3d271b52d7ae78726f5d44ac98b4f4030c91880486"
SRC_URI[wit-bindgen-0.45.1.sha256sum] = "5c573471f125075647d03df72e026074b7203790d41351cd6edc96f46bcccd36"
SRC_URI[writeable-0.6.1.sha256sum] = "ea2f10b9bb0928dfb1b42b65e1f9e36f7f54dbdf08457afefb38afcdec4fa2bb"
SRC_URI[yoke-0.8.0.sha256sum] = "5f41bb01b8226ef4bfd589436a297c53d118f65921786300e427be8d487695cc"
SRC_URI[yoke-derive-0.8.0.sha256sum] = "38da3c9736e16c5d3c8c597a9aaa5d1fa565d0532ae05e27c24aa62fb32c0ab6"
SRC_URI[zerocopy-0.8.27.sha256sum] = "0894878a5fa3edfd6da3f88c4805f4c8558e2b996227a3d864f47fe11e38282c"
SRC_URI[zerocopy-derive-0.8.27.sha256sum] = "88d2b8d9c68ad2b9e4340d7832716a4d21a22a1154777ad56ea55c51a9cf3831"
SRC_URI[zerofrom-0.1.6.sha256sum] = "50cc42e0333e05660c3587f3bf9d0478688e15d870fab3346451ce7f8c9fbea5"
SRC_URI[zerofrom-derive-0.1.6.sha256sum] = "d71e5d6e06ab090c67b5e44993ec16b72dcbaabc526db883a360057678b48502"
SRC_URI[zeroize-1.8.1.sha256sum] = "ced3678a2879b30306d323f4542626697a464a97c0a07c9aebf7ebca65cd4dde"
SRC_URI[zerotrie-0.2.2.sha256sum] = "36f0bbd478583f79edad978b407914f61b2972f5af6fa089686016be8f9af595"
SRC_URI[zerovec-0.11.4.sha256sum] = "e7aa2bd55086f1ab526693ecbe444205da57e25f4489879da80635a46d90e73b"
SRC_URI[zerovec-derive-0.11.1.sha256sum] = "5b96237efa0c878c64bd89c436f661be4e46b2f3eff1ebb976f7ef2321d2f58f"



# Cargo-Source-Verzeichnis (normalerweise das Repo-Root)
#CARGO_SRC_DIR = "${S}"

# Optional: falls dein Binary anders heißt als der Paketname:
# CARGO_BUILD_FLAGS += "--bin rauc-updater"

# Install-Schritt: Binary nach ${bindir} kopieren
do_install() {
    install -d ${D}${bindir}
    install -m 0755 \
        ${B}/target/${TARGET_SYS}/release/rauc-agent ${D}${bindir}/rauc-agent
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
