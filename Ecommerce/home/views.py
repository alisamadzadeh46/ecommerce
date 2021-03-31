from drf_multiple_model.views import ObjectMultipleModelAPIView
from rest_framework.generics import ListAPIView
from .serializer import *


class SliderList(ListAPIView):
    queryset = Slider.objects.all()
    serializer_class = SliderSerializer


class CategoryList(ListAPIView):
    queryset = Category.objects.filter(status=True)
    serializer_class = CategorySerializer


class ProductList(ListAPIView):
    queryset = Product.objects.filter(amazing=True)
    serializer_class = ProductSerializer


class DetailProduct(ObjectMultipleModelAPIView):
    def get_querylist(self):
        id = self.kwargs['pk']

        querylist = (
            {'queryset': Product.objects.filter(id=id), 'serializer_class': ProductSerializer},
            {'queryset': Images.objects.filter(product=id), 'serializer_class': ImageSerializer},
        )

        return querylist


class PropertyProduct(ListAPIView):
    serializer_class = PropertySerializer

    def get_queryset(self):
        id = self.kwargs['pk']
        queryset = Property.objects.filter(product=id)
        return queryset
