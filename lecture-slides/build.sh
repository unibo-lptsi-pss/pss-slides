latexmk -f -bibtex -pdf
cp build/*.pdf .
rm *.backup *.out *.nav *.log *.aux *.snm *.toc
