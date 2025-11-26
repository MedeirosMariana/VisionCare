/**
 * Cria o card de produto como elemento DOM vanilla.
 * Inclui imagem, desconto, categoria, título, rating, preço e botão CTA.
 * @param {Object} product - Objeto com dados do produto
 * @returns {HTMLElement} Card do produto
 */
function productCardComponent(product) {

  // Função de navegação simples.
  function navigateTo(path) {
    window.location.href = path;
  }

  const productCard = document.createElement("div");

  productCard.className =
    "group overflow-hidden border-0 bg-gradient-to-br from-gray-50 to-white rounded-lg hover:shadow-2xl transition-all duration-300 hover:-translate-y-2 cursor-pointer";

  const categoryMap = {
    1: "Óculos de Sol",
    2: "Óculos de Grau",
    3: "Óculos de Leitura",
    4: "Óculos Esportivos"
  };

  const category = categoryMap[product.type] || "Outros";
  const discount = product.discountPercent ? product.discountPercent + "%" : "";
  const rating = product.starsAvg ?? 0;
  const reviews = product.reviewsQuantity ?? 0;

  const price = "R$ " + product.value?.toFixed(2).replace(".", ",");
  const originalPrice = product.discountValue
    ? "R$ " + product.discountValue.toFixed(2).replace(".", ",")
    : "";

  productCard.innerHTML = `
    <div class="relative overflow-hidden">
      <img
        src="${product.image}"
        alt="${product.description}"
        class="w-full h-48 object-cover group-hover:scale-110 transition-transform duration-500"
      />
      <div class="absolute top-3 left-3">
        <span class="bg-green-600 text-white px-2 py-1 rounded-md text-sm font-semibold">
          ${discount}
        </span>
      </div>
      <div class="absolute top-3 right-3">
        <span class="bg-white/90 text-gray-900 px-2 py-1 rounded-md text-sm border">
          ${category}
        </span>
      </div>
    </div>

    <div class="p-6 space-y-4">
      <h3 class="text-xl font-bold text-gray-900 mb-2">${product.description}</h3>

      <div class="flex items-center space-x-2 mb-3">
        <div class="flex items-center">
          ${generateStars(rating)}
        </div>
        <span class="text-sm text-gray-600">
          ${rating} (${reviews} avaliações)
        </span>
      </div>

      <div class="space-y-2">
        <div class="flex items-center space-x-2">
          <div class="w-2 h-2 rounded-full bg-gradient-to-r from-blue-600 to-purple-600"></div>
          <span class="text-sm text-gray-600">Quantidade: ${product.quantity}</span>
        </div>
      </div>

      <div class="flex items-center justify-between">
        <div class="space-y-1">
          <div class="flex items-center space-x-2">
            <span class="text-2xl font-bold text-blue-600">${price}</span>
            <span class="text-sm text-gray-500 line-through">
              ${originalPrice}
            </span>
          </div>
          <p class="text-xs text-gray-500">ou 12x sem juros</p>
        </div>

        <button
          onclick="navigateTo('/finalizarcompra')"
          class="bg-gradient-to-r from-blue-600 to-blue-700 text-white px-4 py-2 rounded-lg"
        >
          Comprar
        </button>
      </div>
    </div>
  `;

  return productCard;
}

function generateStars(rating) {
  let starsHTML = '';
  const fullStars = Math.floor(rating);
  const halfStar = rating % 1 >= 0.5;
  const emptyStars = 5 - fullStars - (halfStar ? 1 : 0);

  // Estrelas cheias
  for (let i = 0; i < fullStars; i++) {
    starsHTML += '<svg class="w-4 h-4 text-yellow-400 fill-current" viewBox="0 0 20 20"><path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.286 3.97a1 1 0 00.95.69h4.175c.969 0 1.371 1.24.588 1.81l-3.38 2.455a1 1 0 00-.364 1.118l1.287 3.97c.3.921-.755 1.688-1.54 1.118l-3.38-2.455a1 1 0 00-1.175 0l-3.38 2.455c-.784.57-1.838-.197-1.54-1.118l1.287-3.97a1 1 0 00-.364-1.118L2.03 9.397c-.783-.57-.38-1.81.588-1.81h4.175a1 1 0 00.95-.69l1.286-3.97z"/></svg>';
  }

  // Estrela meia
  if (halfStar) {
    starsHTML += '<svg class="w-4 h-4 text-yellow-400 fill-current" viewBox="0 0 20 20"><defs><linearGradient id="half"><stop offset="50%" stop-color="currentColor"/><stop offset="50%" stop-color="transparent"/></linearGradient></defs><path fill="url(#half)" d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.286 3.97a1 1 0 00.95.69h4.175c.969 0 1.371 1.24.588 1.81l-3.38 2.455a1 1 0 00-.364 1.118l1.287 3.97c.3.921-.755 1.688-1.54 1.118l-3.38-2.455a1 1 0 00-1.175 0l-3.38 2.455c-.784.57-1.838-.197-1.54-1.118l1.287-3.97a1 1 0 00-.364-1.118L2.03 9.397c-.783-.57-.38-1.81.588-1.81h4.175a1 1 0 00.95-.69l1.286-3.97z"/></svg>';
  }

  // Estrelas vazias
  for (let i = 0; i < emptyStars; i++) {
    starsHTML += '<svg class="w-4 h-4 text-gray-300 fill-current" viewBox="0 0 20 20"><path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.286 3.97a1 1 0 00.95.69h4.175c.969 0 1.371 1.24.588 1.81l-3.38 2.455a1 1 0 00-.364 1.118l1.287 3.97c.3.921-.755 1.688-1.54 1.118l-3.38-2.455a1 1 0 00-1.175 0l-3.38 2.455c-.784.57-1.838-.197-1.54-1.118l1.287-3.97a1 1 0 00-.364-1.118L2.03 9.397c-.783-.57-.38-1.81.588-1.81h4.175a1 1 0 00.95-.69l1.286-3.97z"/></svg>';
  }

  return starsHTML;
}


