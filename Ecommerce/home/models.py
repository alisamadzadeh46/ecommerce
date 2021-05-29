from ckeditor_uploader.fields import RichTextUploadingField
from django.db import models
from django.utils.safestring import mark_safe
from mptt.models import MPTTModel
from treewidget.fields import TreeForeignKey


class Slider(models.Model):
    name = models.CharField(max_length=200, verbose_name="name")
    image = models.ImageField(verbose_name="image", upload_to='slider_main')

    def slider_image(self):
        return mark_safe('<img src="{}" height="50"/>'.format(self.image.url))

    def __str__(self):
        return self.name


class Category(MPTTModel):
    STATUS = (
        ('True', 'True'),
        ('False', 'False')
    )
    parent = TreeForeignKey('self', blank=True, null=True, related_name='children', on_delete=models.CASCADE)
    title = models.CharField(max_length=200, verbose_name="title", null=False)
    image = models.ImageField(verbose_name="image", upload_to='category')
    slug = models.SlugField(null=False, unique=True)
    status = models.CharField(max_length=10, choices=STATUS, default=True)
    create_at = models.DateTimeField(auto_now_add=True)
    update_at = models.DateTimeField(auto_now=True)

    class Meta:
        verbose_name = 'Category'
        verbose_name_plural = 'Categories'

    class MTTPMeta:
        order_insertion_by = ['title']

    def __str__(self):
        full_path = [self.title]
        k = self.parent
        while k is not None:
            full_path.append(k.title)
            k = k.parent
        return ' / '.join(full_path[::-1])


class Product(models.Model):
    STATUS = (
        ('True', 'True'),
        ('False', 'False')
    )
    category = models.ForeignKey(Category,on_delete=models.CASCADE, verbose_name="category")
    title = models.CharField(max_length=255, verbose_name="title")
    keywords = models.CharField(max_length=255, verbose_name="keywords")
    description = models.CharField(max_length=255, verbose_name="description")
    image = models.ImageField(blank=False, null=False, upload_to="product_main")
    price = models.IntegerField(verbose_name="price")
    amount = models.IntegerField(null=False, blank=False, default=0, verbose_name="amount")
    offer = models.IntegerField(verbose_name="offer")
    detail = RichTextUploadingField(verbose_name="detail")
    slug = models.SlugField(null=False, unique=True, verbose_name="slug")
    status = models.CharField(max_length=10, choices=STATUS, verbose_name="status")
    color = models.CharField(max_length=255, verbose_name="color")
    score = models.FloatField()
    club = models.CharField(max_length=255, verbose_name="club")
    warranty = models.CharField(max_length=255, verbose_name="warranty")
    amazing = models.BooleanField(default=False)
    create_at = models.DateTimeField(auto_now_add=True)
    update_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return self.title

    def image_tag(self):
        return mark_safe('<img src="{}" height="50"/>'.format(self.image.url))

    image_tag.short_description = 'Image'


class Images(models.Model):
    product = models.ForeignKey(Product, on_delete=models.CASCADE, verbose_name="product")
    title = models.CharField(max_length=50, blank=True, verbose_name="title")
    image = models.ImageField(blank=True, upload_to="product_image", verbose_name="image")

    def image_tag(self):
        return mark_safe('<img src="{}" height="50"/>'.format(self.image.url))

    def __str__(self):
        return self.title


class Property(models.Model):
    product = models.ForeignKey(Product, on_delete=models.CASCADE, verbose_name="product")
    title = models.CharField(max_length=50, blank=True, verbose_name="title")
    value = models.CharField(max_length=50, blank=True, verbose_name="value")

    def __str__(self):
        return self.title


class Rating(models.Model):
    product = models.ForeignKey(Product, on_delete=models.CASCADE, verbose_name="product")
    title = models.CharField(max_length=50, blank=True, verbose_name="title")
    value = models.FloatField(max_length=50, blank=True, verbose_name="value")

    def __str__(self):
        return self.title


class Price(models.Model):
    product = models.ForeignKey(Product, on_delete=models.CASCADE, related_name='children', verbose_name="product")
    title = models.CharField(max_length=50, blank=False, null=False, verbose_name="title")
    price = models.IntegerField(blank=False, verbose_name="price", null=False)
    create_at = models.DateField(auto_now_add=True)
    update_at = models.DateField(auto_now=True)

    def __str__(self):
        return self.title
