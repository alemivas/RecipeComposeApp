package com.example.recipecomposeapp.data.repository

import com.example.recipecomposeapp.data.model.CategoryDto
import com.example.recipecomposeapp.data.model.IngredientDto
import com.example.recipecomposeapp.data.model.RecipeDto

private val categories = listOf(
    CategoryDto(id = 0, title = "Бургеры", description = "Рецепты всех популярных видов бургеров", imageUrl = "burger.png"),
    CategoryDto(id = 1, title = "Десерты", description = "Самые вкусные рецепты десертов специально для вас", imageUrl = "dessert.png"),
    CategoryDto(id = 2, title = "Пицца", description = "Пицца на любой вкус и цвет. Лучшая подборка для тебя", imageUrl = "pizza.png"),
    CategoryDto(id = 3, title = "Рыба", description = "Печеная, жареная, сушеная, любая рыба на твой вкус", imageUrl = "fish.png"),
    CategoryDto(id = 4, title = "Супы", description = "От классики до экзотики: мир в одной тарелке", imageUrl = "soup.png"),
    CategoryDto(id = 5, title = "Салаты", description = "Хрустящий калейдоскоп под соусом вдохновения", imageUrl = "salad.png"),
)

private val burgerRecipes = listOf(
    RecipeDto(
        id = 0,
        title = "Классический бургер с говядиной",
        ingredients = listOf(
            IngredientDto(quantity = "0.5", unitOfMeasure = "кг", description = "говяжий фарш"),
            IngredientDto(quantity = "1.0", unitOfMeasure = "шт", description = "луковица, мелко нарезанная"),
            IngredientDto(quantity = "2.0", unitOfMeasure = "зубч", description = "чеснок, измельченный"),
            IngredientDto(quantity = "4.0", unitOfMeasure = "шт", description = "булочки для бургера"),
            IngredientDto(quantity = "4.0", unitOfMeasure = "шт", description = "листа салата"),
            IngredientDto(quantity = "1.0", unitOfMeasure = "шт", description = "помидор, нарезанный кольцами"),
            IngredientDto(quantity = "2.0", unitOfMeasure = "ст. л.", description = "горчица"),
            IngredientDto(quantity = "2.0", unitOfMeasure = "ст. л.", description = "кетчуп"),
            IngredientDto(quantity = "по вкусу", unitOfMeasure = "", description = "соль и черный перец"),
        ),
        method = listOf(
            "В глубокой миске смешайте говяжий фарш, лук, чеснок, соль и перец. Разделите фарш на 4 равные части и сформируйте котлеты.",
            "Разогрейте сковороду на среднем огне. Обжаривайте котлеты с каждой стороны в течение 4-5 минут или до желаемой степени прожарки.",
            "В то время как котлеты готовятся, подготовьте булочки. Разрежьте их пополам и обжарьте на сковороде до золотистой корочки.",
            "Смазать нижние половинки булочек горчицей и кетчупом, затем положите лист салата, котлету, кольца помидора и закройте верхней половинкой булочки.",
            "Подавайте бургеры горячими с картофельными чипсами или картофельным пюре."
        ),
        imageUrl = "burger-hamburger.png"
    ),

    RecipeDto(
        id = 1,
        title = "Чизбургер с беконом",
        ingredients = listOf(
            IngredientDto(quantity = "0.4", unitOfMeasure = "кг", description = "говяжий фарш"),
            IngredientDto(quantity = "4.0", unitOfMeasure = "шт", description = "ломтика бекона"),
            IngredientDto(quantity = "4.0", unitOfMeasure = "шт", description = "ломтика сыра чеддер"),
            IngredientDto(quantity = "4.0", unitOfMeasure = "шт", description = "булочки для бургера"),
            IngredientDto(quantity = "1.0", unitOfMeasure = "шт", description = "помидор, нарезанный"),
            IngredientDto(quantity = "по вкусу", unitOfMeasure = "", description = "майонез и кетчуп"),
        ),
        method = listOf(
            "Обжарьте бекон на сковороде до хрустящей корочки, отложите на бумажное полотенце.",
            "Сформируйте из фарша 4 котлеты, обжарьте с каждой стороны по 4 минуты.",
            "За минуту до готовности положите на каждую котлету по ломтику сыра, чтобы он расплавился.",
            "Соберите бургер: булочка, майонез, котлета с сыром, бекон, помидор, кетчуп.",
            "Подавайте горячими."
        ),
        imageUrl = "burger-cheeseburger.png"
    ),
)

private val dessertRecipes = listOf(
    RecipeDto(
        id = 2,
        title = "Ягодный мусс",
        ingredients = listOf(
            IngredientDto(quantity = "250", unitOfMeasure = "г", description = "Ягоды замороженные/свежие"),
            IngredientDto(quantity = "15", unitOfMeasure = "г", description = "Быстрорастворимый желатин"),
            IngredientDto(quantity = "5", unitOfMeasure = "ст. л.", description = "Сахар"),
            IngredientDto(quantity = "100", unitOfMeasure = "мл", description = "Вода"),
            IngredientDto(quantity = "10", unitOfMeasure = "г", description = "Ванильный сахар"),
        ),
        method = listOf(
            "Разморозьте замороженные ягоды или вымойте, обсушите и переберите свежие, отделив плодоножки и листья. В данном рецепте использована смесь замороженных ягод красной и черной смородины, с добавлением нескольких щепоток малины и ежевики.",
            "Растворите желатин в горячей воде и охладите до комнатной температуры.",
            "Измельчите ягоды до состояния пюре (с помощью пестика или блендера). Затем протрите пюре через сито, отделив косточки и крупные кусочки кожуры.",
            "Получившуюся ягодную массу поместите в глубокую емкость. Добавьте ваниль и сахар и взбейте все 3-4 минуты, пока сахар не растворится.",
            "Продолжая взбивать смесь, тонкой струйкой влейте растопленный желатин.",
            "Взбейте смесь еще 10-12 минут, пока она не увеличится в объеме в два раза и не посветлеет.",
            "Распределите массу по креманкам или бокалам и полностью охладите, поместив в холодильник на 3-4 часа. По мере охлаждения десерт застынет, но сохранит свою пышность и воздушную текстуру.",
            "Ягодный мусс готов. Храните десерт в холодильнике и подавайте охлажденным.",
        ),
        imageUrl = "dessert-v-stakane.jpg"
    ),

    RecipeDto(
        id = 3,
        title = "Кокосово-шоколадный рулет",
        ingredients = listOf(
            IngredientDto(quantity = "7", unitOfMeasure = "г", description = "сахар"),
            IngredientDto(quantity = "33", unitOfMeasure = "мл", description = "кипяток"),
            IngredientDto(quantity = "0.7", unitOfMeasure = "ст. л.", description = "какао-порошок"),
            IngredientDto(quantity = "33", unitOfMeasure = "г", description = "кокосовая стружка"),
            IngredientDto(quantity = "20", unitOfMeasure = "г", description = "сахарная пудра"),
            IngredientDto(quantity = "0.2", unitOfMeasure = "ч. л.", description = "сахар ванильный"),
            IngredientDto(quantity = "26", unitOfMeasure = "г", description = "сливочное масло"),
        ),
        method = listOf(
            "Для тёмного шоколадного слоя возьмём рассыпчатое печенье и измельчим его в крошку.",
            "Какао смешать с сахаром.",
            "Влить горячую воду и немного ароматного рома или бальзама (по желанию). Перемешать.",
            "Вылить, не остужая, в крошку из печенья.",
            "Мягкую тёплую массу разминаем по плотной плёнке, потом прокатываем слегка скалкой (если скалка пластиковая, за деревянную не ручаюсь, что не прилипнет!). Я нашла плотный пакет и разрезала его на две половинки, получилось 2 прямоугольника. Плёнку я на всякий случай смазала чайной ложкой растительного масла без запаха.",
            "Для белого сливочного слоя смешиваем кокосовую стружку с пудрой и ванилью.",
        ),
        imageUrl = "dessert-kokos-shoko-rulet.jpg"
    ),
)

fun getCategories(): List<CategoryDto> {
    return categories
}

fun getRecipesByCategoryId(categoryId: Int): List<RecipeDto> {
    return when (categoryId) {
        0 -> burgerRecipes  // Имитация GET /category/0/recipes
        1 -> dessertRecipes  // Имитация GET /category/1/recipes
        else -> emptyList() // Остальные категории пока пустые
    }
}

fun getRecipeById(recipeId: Int?): RecipeDto? {
    return when (recipeId) {
        0 -> burgerRecipes[0]
        1 -> burgerRecipes[1]
        2 -> dessertRecipes[0]
        3 -> dessertRecipes[1]
        else -> null
    }
}