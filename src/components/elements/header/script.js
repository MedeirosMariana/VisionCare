/**
 * Cria o componente Header como elemento DOM vanilla.
 * Simula estado do menu mobile e navegação com JS puro.
 * @returns {HTMLElement} O elemento <header> completo.
 */
function headerElement() {
  // Estado para menu mobile (simula useState)
  let isMenuOpen = false;

  // Função utilitária para scroll suave para seções da página
  function scrollToSection(sectionId) {
    const element = document.getElementById(sectionId);
    if (element) {
      element.scrollIntoView({ behavior: 'smooth' });
      toggleMobileMenu(); // Fecha menu mobile após scroll
    }
  }

  // Função de navegação simples (simula useNavigate do React)
  function navigateTo(path) {
    window.location.href = path;  // Redireciona para página
    toggleMobileMenu();           // Fecha menu mobile após navegação
  }

  // Função para alternar o menu mobile
  function toggleMobileMenu() {
    isMenuOpen = !isMenuOpen;
    const mobileNav = header.querySelector('#mobileNav');
    const menuIcon = header.querySelector('#menuIcon');

    if (isMenuOpen) {
      mobileNav.classList.remove('hidden');
      menuIcon.innerHTML = getXIcon();    // Ícone X ao abrir
    } else {
      mobileNav.classList.add('hidden');
      menuIcon.innerHTML = getMenuIcon(); // Ícone Menu ao fechar
    }
  }

  // ===== SVG Icons =====

  // Ícone Eye (logo)
  function getEyeIcon() {
    return `
      <svg class="w-5 h-5 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"></path>
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"></path>
      </svg>
    `;
  }

  // Ícone Menu (hamburger)
  function getMenuIcon() {
    return `
      <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"></path>
      </svg>
    `;
  }

  // Ícone X (fechar)
  function getXIcon() {
    return `
      <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12"></path>
      </svg>
    `;
  }

  // ===== Criação do elemento header =====
  const header = document.createElement('header');
  header.className = 'fixed z-10 top-0 left-0 right-0 bg-white/90 backdrop-blur-md border-b border-gray-200';

  // HTML interno do Header
  header.innerHTML = `
    <div class="container mx-auto px-4 lg:px-8 max-w-[1280px]">
      <div class="flex items-center justify-between h-16">

        <!-- Logo -->
        <div class="flex items-center space-x-2 cursor-pointer" onclick="navigateTo('/')">
          <div class="w-8 h-8 bg-gradient-to-r from-blue-600 to-green-600 rounded-lg flex items-center justify-center">
              ${getEyeIcon()}
          </div>
          <span class="text-xl font-bold text-blue-600">Vision Care</span> 
        </div>

        <!-- Desktop Navigation -->
        <nav class="hidden md:flex items-center space-x-8">
          <button onclick="scrollToSection('services')" class="text-gray-900 hover:text-blue-600 transition-colors">Serviços</button>
          <button onclick="navigateTo('/src/pages/produtos.html')" class="text-gray-900 hover:text-blue-600 transition-colors">Produtos</button>
          <button onclick="scrollToSection('universities')" class="text-gray-900 hover:text-blue-600 transition-colors">Universidades</button>
          <button onclick="navigateTo('/src/pages/contato.html')" class="text-gray-900 hover:text-blue-600 transition-colors">Contato</button>
        </nav>

        <!-- CTA Button Desktop -->
        <div class="hidden md:block">
          <button 
            class="px-6 py-2 bg-gradient-to-r from-blue-600 to-green-600 text-white font-medium rounded-lg hover:opacity-90 transition-opacity shadow-lg" 
            onclick="navigateTo('/src/pages/agendarconsulta.html')"
          >
            Agendar Consulta
          </button>
        </div>

        <!-- Mobile Menu Button -->
        <button id="mobileMenuBtn" class="md:hidden p-2 text-gray-900" onclick="toggleMobileMenu()">
          <span id="menuIcon">${getMenuIcon()}</span>
        </button>
      </div>

      <!-- Mobile Navigation (inicialmente hidden) -->
      <div id="mobileNav" class="md:hidden hidden py-4 space-y-4 border-t border-gray-200">
        <button onclick="navigateTo('/servicos')" class="block w-full text-left text-gray-900 hover:text-blue-600 transition-colors py-2">Serviços</button>
        <button onclick="navigateTo('/produtos')" class="block w-full text-left text-gray-900 hover:text-blue-600 transition-colors py-2">Produtos</button>
        <button onclick="scrollToSection('universities')" class="block w-full text-left text-gray-900 hover:text-blue-600 transition-colors py-2">Universidades</button>
        <button onclick="scrollToSection('contact')" class="block w-full text-left text-gray-900 hover:text-blue-600 transition-colors py-2">Contato</button>
        <button onclick="navigateTo('/agendarconsulta.html')" class="w-full px-6 py-2 bg-gradient-hero text-white font-medium rounded-lg hover:opacity-90 transition-opacity mt-2" style="background: linear-gradient(135deg, #3b82f6 0%, #8b5cf6 100%);">
          Agendar Consulta
        </button>
      </div>
    </div>
  `;

  // ===== Tornando funções globais para serem usadas em innerHTML =====
  window.scrollToSection = scrollToSection;
  window.navigateTo = navigateTo;
  window.toggleMobileMenu = toggleMobileMenu;

  // Fecha menu mobile ao clicar fora (melhora UX)
  header.addEventListener('click', (e) => {
    if (!e.target.closest('#mobileMenuBtn') && !e.target.closest('#mobileNav') && isMenuOpen) {
      toggleMobileMenu();
    }
  });

  return header;
}
