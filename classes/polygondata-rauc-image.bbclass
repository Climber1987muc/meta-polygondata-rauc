
# meta-polygondata-base-image/classes/polygondata-base-image.bbclass

inherit polygondata-base-image

IMAGE_INSTALL:append = " \
		rauc \
		rauc-health \
		rauc-agent \
"


# Optional dbus raus (nur wenn du sicher bist, dass dein Stack ohne läuft)
POLY_NO_DBUS ?= "0"
IMAGE_INSTALL:remove = "${@'dbus' if d.getVar('POLY_NO_DBUS') == '1' else ''}"
BAD_RECOMMENDATIONS:append = " ${@'dbus' if d.getVar('POLY_NO_DBUS') == '1' else ''}"
