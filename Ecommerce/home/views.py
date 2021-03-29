from rest_framework.generics import ListAPIView
from .serializer import *


class SliderList(ListAPIView):
    queryset = Slider.objects.all()
    serializer_class = ProductSerializer


class CategoryList(ListAPIView):
    queryset = Category.objects.filter(status=True)
    serializer_class = CategorySerializer


class AmazingList(ListAPIView):
    queryset = Product.objects.filter(amazing=True)
    serializer_class = AmazingSerializer
