from django.contrib import admin
from mptt.admin import DraggableMPTTAdmin

from .models import *


@admin.register(Slider)
class SliderAdmin(admin.ModelAdmin):
    list_display = ('name', 'slider_image')
    readonly_fields = ('slider_image',)


@admin.register(Category)
class CategoryAdmin2(DraggableMPTTAdmin):
    mptt_indent_field = "title"
    list_display = ('tree_actions', 'indented_title',
                    'related_products_count', 'related_products_cumulative_count')
    list_display_links = ('indented_title',)
    prepopulated_fields = {'slug': ('title',)}

    def get_queryset(self, request):
        qs = super().get_queryset(request)

        qs = Category.objects.add_related_count(
            qs,
            Product,
            'category',
            'products_cumulative_count',
            cumulative=True)

        qs = Category.objects.add_related_count(qs,
                                                Product,
                                                'category',
                                                'products_count',
                                                cumulative=False)
        return qs

    def related_products_count(self, instance):
        return instance.products_count

    related_products_count.short_description = 'Related products (for this specific category)'

    def related_products_cumulative_count(self, instance):
        return instance.products_cumulative_count

    related_products_cumulative_count.short_description = 'Related products (in tree)'


class ProductImageInline(admin.TabularInline):
    model = Images
    extra = 5


@admin.register(Product)
class ProductAdmin(admin.ModelAdmin):
    list_display = ['title', 'category', 'status', 'image_tag']
    list_filter = ['category']
    readonly_fields = ('image_tag',)
    inlines = [ProductImageInline]
    prepopulated_fields = {'slug': ('title',)}


@admin.register(Images)
class Image(admin.ModelAdmin):
    list_display = ['product', 'title', 'image_tag']
    readonly_fields = ('image_tag',)


@admin.register(Property)
class PropertyAdmin(admin.ModelAdmin):
    list_display = ['product', 'title', 'value']


@admin.register(Rating)
class PropertyAdmin(admin.ModelAdmin):
    list_display = ['product', 'title', 'value']


@admin.register(Price)
class PriceAdmin(admin.ModelAdmin):
    list_display = ['product', 'title', 'price']

