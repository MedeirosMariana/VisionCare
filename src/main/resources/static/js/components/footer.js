/**
 * Cria o componente Footer como elemento DOM vanilla.
 * Inclui seções de brand, links, contato e bottom bar com ano atual.
 * @returns {HTMLElement} O elemento <footer> completo.
 */
function footerElement() {
  // Cria o elemento footer principal
  const footer = document.createElement('footer');
  footer.className = 'flex flex-col bg-blue-600 text-white';

  // Adiciona o conteúdo HTML do footer
  footer.innerHTML = `
    <div class="flex flex-col md:flex-row w-[100%] justify-between items-center md:space-y-0 max-w-[1280px] py-4 mx-auto px-4">
      <!-- Logo e Brand -->
      <div class="flex items-center space-x-2">
        <div class="w-10 h-10 bg-white rounded-lg flex items-center justify-center">
          ${getEyeIcon()} 
        </div>
        <span class="text-2xl font-bold">Vision Care</span>
      </div>

      <!-- Contato: endereço, telefone, e-mail -->
      <div class="flex flex-col md:flex-row gap-4 md:gap-6 items-center">
        <!-- Endereço -->
        <div class="flex items-center space-x-2">
          ${getMapPinIcon()}
          <span class="text-white/80 text-sm">Rua dos Universitários, 123 - Centro, São Paulo - SP</span>
        </div>
        <!-- Telefone -->
        <div class="flex items-center space-x-2">
          ${getPhoneIcon()}
          <span class="text-white/80 text-sm">(11) 3456-7890</span>
        </div>
        <!-- E-mail -->
        <div class="flex items-center space-x-2">
          ${getMailIcon()}
          <span class="text-white/80 text-sm">contato@universityvision.com</span>
        </div>
      </div>

      <!-- Social Media -->
      <div class="flex space-x-4">
        <a href="#" class="w-10 h-10 bg-white/10 rounded-lg flex items-center justify-center hover:bg-white/20 transition-colors">
          ${getInstagramIcon()}
        </a>
        <a href="#" class="w-10 h-10 bg-white/10 rounded-lg flex items-center justify-center hover:bg-white/20 transition-colors">
          ${getFacebookIcon()}
        </a>
        <a href="#" class="w-10 h-10 bg-white/10 rounded-lg flex items-center justify-center hover:bg-white/20 transition-colors">
          ${getTwitterIcon()}
        </a>
      </div>
    </div>

    <!-- Bottom Bar com ano atual -->
    <div class="w-[100%] bg-blue-700 py-2 mt-4 text-center text-white/70 text-sm">
      &copy; ${new Date().getFullYear()} Vision Care. Todos os direitos reservados.
    </div>
  `;

  return footer;
}

/**
 * Função auxiliar para criar seções de links no footer (Services, Company etc.)
 * @param {string} title - Título da seção
 * @param {Array} links - Array de objetos {name, href}
 * @returns {HTMLElement} O div da seção com <ul>
 */
function createFooterLinksSection(title, links) {
  const section = document.createElement('div');

  let linksHTML = '<ul class="space-y-3">';
  links.forEach(link => {
    linksHTML += `
      <li>
        <a href="${link.href}" class="text-white/80 hover:text-white transition-colors text-sm">
          ${link.name}
        </a>
      </li>
    `;
  });
  linksHTML += '</ul>';

  section.innerHTML = `
    <h4 class="font-semibold mb-4">${title}</h4>
    ${linksHTML}
  `;

  return section;
}

// ---------- Funções SVG ---------- //

function getEyeIcon() {
  return `
    <svg class="w-6 h-6 text-blue-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"></path>
      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"></path>
    </svg>
  `;
}

function getMapPinIcon() {
  return `
  <svg class="w-4 h-4 flex-shrink-0" fill="none" stroke="currentColor" viewBox="0 0 24 24">
    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z"></path>
    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 11a3 3 0 11-6 0 3 3 0 016 0z"></path>
  </svg>`;
}

function getPhoneIcon() {
  return `
  <svg class="w-4 h-4 flex-shrink-0" fill="none" stroke="currentColor" viewBox="0 0 24 24">
    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 5a2 2 0 012-2h3.28a1 1 0 01.948.684l1.498 4.493a1 1 0 01-.502 1.21l-2.257 1.13a11.042 11.042 0 005.516 5.516l1.13-2.257a1 1 0 011.21-.502l4.493 1.498a1 1 0 01.684.949V19a2 2 0 01-2 2h-1C9.716 21 3 14.284 3 6V5z"></path>
  </svg>`;
}

function getMailIcon() {
  return `
  <svg class="w-4 h-4 flex-shrink-0" fill="none" stroke="currentColor" viewBox="0 0 24 24">
    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 8l7.89 4.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z"></path>
  </svg>`;
}

function getInstagramIcon() {
  return `
  <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 24 24">
    <path d="M7.8,2H16.2C19.4,2 22,4.6 22,7.8V16.2A5.8,5.8 0 0,1 16.2,22H7.8C4.6,22 2,19.4 2,16.2V7.8A5.8,5.8 0 0,1 7.8,2M7.6,4A3.6,3.6 0 0,0 4,7.6V16.4C4,18.39 5.61,20 7.6,20H16.4A3.6,3.6 0 0,0 20,16.4V7.6C20,5.61 18.39,4 16.4,4H7.6M17.25,5.5A1.25,1.25 0 0,1 18.5,6.75A1.25,1.25 0 0,1 17.25,8A1.25,1.25 0 0,1 16,6.75A1.25,1.25 0 0,1 17.25,5.5M12,7A5,5 0 0,1 17,12A5,5 0 0,1 12,17A5,5 0 0,1 7,12A5,5 0 0,1 12,7M12,9.5A2.5,2.5 0 0,0 9.5,12A2.5,2.5 0 0,0 12,14.5A2.5,2.5 0 0,0 14.5,12A2.5,2.5 0 0,0 12,9.5Z"></path>
  </svg>`;
}

function getFacebookIcon() {
  return `
  <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 24 24">
    <path d="M24 12.073c0-6.627-5.373-12-12-12s-12 5.373-12 12c0 5.99 4.388 10.954 10.125 11.854v-8.385H7.078v-3.47h3.047V9.43c0-3.007 1.792-4.669 4.533-4.669 1.312 0 2.686.235 2.686.235v2.953H15.83c-1.491 0-1.956.925-1.956 1.874v2.25h3.328l-.532 3.47h-2.796v8.385C19.612 23.027 24 18.062 24 12.073z"></path>
  </svg>`;
}

function getTwitterIcon() {
  return `
  <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 24 24">
    <path d="M23.953 4.57a10 10 0 01-2.825.775 4.958 4.958 0 002.163-2.723c-.951.555-2.005.959-3.127 1.184a4.92 4.92 0 00-8.384 4.482C7.69 8.095 4.067 6.13 1.64 3.162a4.822 4.822 0 00-.666 2.475c0 1.71.87 3.213 2.188 4.096a4.904 4.904 0 01-2.228-.616v.06a4.923 4.923 0 003.946 4.827 4.996 4.996 0 01-2.212.085 4.936 4.936 0 004.604 3.417 9.867 9.867 0 01-6.102 2.105c-.39 0-.779-.023-1.17-.067a13.995 13.995 0 007.557 2.209c9.053 0 13.998-7.496 13.998-13.985 0-.21 0-.42-.015-.63A9.935 9.935 0 0024 4.59z"></path>
  </svg>
  `;
}
