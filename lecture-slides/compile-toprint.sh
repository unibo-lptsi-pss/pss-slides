pdflatex -jobname="${1%.tex}.toprint" "\def\ishandout{1} \input{$1}"
pdfnup --a4paper --landscape --nup 1x2 --scale 0.95 --offset '-7.5cm 0cm' --delta '0.2cm 0.2cm' --frame true "${1%.tex}.toprint.pdf" --outfile "${1%.tex}.toprint.pdf"

