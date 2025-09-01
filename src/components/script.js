/**
 * Função responsável por carregar um componente.
 * @param elementId Identificador do elemento.
 * @param filePath Caminho do  arquivo.
 */
function loadComponent(elementId, filePath, cssPath = null) {
  fetch(filePath)
    .then(response => {
      if (!response.ok) throw new Error(`Erro ao carregar ${filePath}`);

      return response.text();
    })
    .then(html => {
      document.getElementById(elementId).innerHTML = html;

      // Se foi passado um caminho de CSS, cria o <link> para estilização.
      if (cssPath) {
        const existingLink = document.querySelector(`link[href="${cssPath}"]`);

        if (!existingLink) {
          const link = document.createElement("link");
          link.rel = "stylesheet";
          link.href = cssPath;
          document.head.appendChild(link);
        }
      }
    })
    .catch(error => console.log("Erro ao carregar componente", error))
}