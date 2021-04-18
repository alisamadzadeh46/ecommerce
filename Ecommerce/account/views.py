from rest_framework.generics import ListAPIView
from rest_framework.permissions import IsAuthenticated

from .serializer import *


class AddFavorite(ListAPIView):
    data = serializer_class = FavoriteSerializer
    permission_classes = [IsAuthenticated]

    def get_queryset(self):
        queryset = Favorite.objects.all()
        id = self.request.query_params.get('id')
        if id is not None:
            queryset = queryset.filter(product=id)
        return queryset
